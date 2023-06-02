package com.maciio.chatgptservice.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Mario A. Pineda on 6/1/23.
 */
public record ChatGPTResponse (
        String id,
        String object,
        String model,
        LocalDate created,
        List<Choice> choices
){}
