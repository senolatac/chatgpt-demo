package com.example.chatgptdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class ChatgptDemoApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder
                .setConnectTimeout(Duration.ofSeconds(30))
                .setReadTimeout(Duration.ofSeconds(30))
                .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(ChatgptDemoApplication.class, args);
	}

}
