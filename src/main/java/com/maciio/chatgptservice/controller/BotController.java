package com.maciio.chatgptservice.controller;

import com.maciio.chatgptservice.model.BotRequest;
import com.maciio.chatgptservice.model.ChatGPTResponse;
import com.maciio.chatgptservice.service.BotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mario A. Pineda on 6/1/23.
 */
@RestController
@RequestMapping("/api/v1/bot")
public class BotController {

    private static final Logger log = LoggerFactory.getLogger(BotController.class);
    
    private final BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @PostMapping("/ask")
    public ChatGPTResponse askQuestion(@RequestBody BotRequest botRequest) {
        log.info("controller....");
        return botService.askQuestion(botRequest);
    }
}
