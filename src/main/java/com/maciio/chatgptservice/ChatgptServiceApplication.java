package com.maciio.chatgptservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ChatgptServiceApplication {

	public static void main(String... args) {
		SpringApplication.run(ChatgptServiceApplication.class, args);
	}

}
