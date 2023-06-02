package com.maciio.chatgptservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Mario A. Pineda on 6/1/23.
 */
@Configuration
public class ChatGPTConfig {

    private final ChatGPTProperties chatGPTProperties;

    public ChatGPTConfig(ChatGPTProperties chatGPTProperties) {
        this.chatGPTProperties = chatGPTProperties;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + chatGPTProperties.apiKey());
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
