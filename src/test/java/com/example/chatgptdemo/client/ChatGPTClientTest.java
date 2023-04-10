package com.example.chatgptdemo.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sa
 * @date 10.04.2023
 * @time 13:36
 */
@Slf4j
@SpringBootTest
class ChatGPTClientTest
{
    @Autowired
    private ChatGPTClient chatGPTClient;

    @Test
    void createImageEditWithHttpOk() throws IOException
    {
        String result = chatGPTClient.createImageEditWithOkHttp("man holding happy birthday banner");

        assertThat(result).isNotBlank();

        log.info(result);
    }

    @Test
    void createImageEditWithRestTemplate() throws IOException
    {
        String result = chatGPTClient.createImageEditWithRestTemplate("man holding happy birthday banner");

        assertThat(result).isNotBlank();

        log.info(result);
    }
}
