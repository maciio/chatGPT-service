package com.maciio.chatgptservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Mario A. Pineda on 6/1/23.
 */
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "chapgt.service")
public record ChatGPTProperties(
        String url,
        String model,
        String apiKey,
        Integer maxTokens,
        Double temperature,
        Double topP
) {
}
