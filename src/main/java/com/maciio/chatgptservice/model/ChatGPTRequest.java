package com.maciio.chatgptservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Mario A. Pineda on 6/1/23.
 */
public record ChatGPTRequest(
        String model,
        String prompt,
        @JsonProperty("max_tokens")
        Integer maxTokens,
        Double temperature,
        @JsonProperty("top_p")
        Double topP
) {}
