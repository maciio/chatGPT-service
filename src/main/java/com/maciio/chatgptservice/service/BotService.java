package com.maciio.chatgptservice.service;

import com.maciio.chatgptservice.config.ChatGPTProperties;
import com.maciio.chatgptservice.model.BotRequest;
import com.maciio.chatgptservice.model.ChatGPTRequest;
import com.maciio.chatgptservice.model.ChatGPTResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Mario A. Pineda on 6/1/23.
 */
@Service
public class BotService {

    private static final Logger log = LoggerFactory.getLogger(BotService.class);

    RestTemplate restTemplate;
    private final ChatGPTProperties chatGPTProperties;
    //    public ChatGPTResponse
    private static final String MEDIA_TYPE = "application/json";
    private static final String AUTHORIZATION = "AUTHORIZATION";
    private static final String BEARER = "Bearer ";


    public BotService(RestTemplate restTemplate, ChatGPTProperties chatGPTProperties) {
        this.restTemplate = restTemplate;
        this.chatGPTProperties = chatGPTProperties;
    }

    public HttpEntity<ChatGPTRequest> buildHttpEntity(ChatGPTRequest chatRequest) {
        log.debug("building entity...");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MEDIA_TYPE));
//        headers.add(AUTHORIZATION, BEARER.concat(chatGPTProperties.apiKey()));
        return new HttpEntity<>(chatRequest, headers);
    }

    public ChatGPTResponse askQuestion(BotRequest botRequest) {
        log.debug("asking a question: " + chatGPTProperties.toString());
        log.info(botRequest.message());
        HttpEntity<ChatGPTRequest> chatGptHttpEntity = buildHttpEntity(
                new ChatGPTRequest(
                        chatGPTProperties.model(),
                        botRequest.message(),
                        chatGPTProperties.maxTokens(),
                        chatGPTProperties.temperature(),
                        chatGPTProperties.topP()
                )
        );
        ResponseEntity<ChatGPTResponse> responseEntity = restTemplate.postForEntity(chatGPTProperties.url(),
                chatGptHttpEntity, ChatGPTResponse.class);

        return responseEntity.getBody();
    }
}
