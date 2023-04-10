package com.example.chatgptdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sa
 * @date 10.04.2023
 * @time 12:39
 */
@Slf4j
@SpringBootTest
class ImageGenerationServiceTest
{
    @Autowired
    private ImageGenerationService imageGenerationService;

    @Test
    void generateImageFromText()
    {
        List<String> result = imageGenerationService.generateImageFromText("Purple Spotify logo");

        assertThat(result).hasSize(1);

        log.info(result.toString());
    }

    @Test
    void generateImageFromUrl()
    {
        String url = "https://img-s1.onedio.com/id-640ef94c236f7a3c0f8acedd/rev-0/w-620/f-jpg/s-80827b2de9804ab19c2611dac60640a3e060d65d.jpg";

        List<String> result = imageGenerationService.generateImageFromUrl(url);

        assertThat(result).hasSize(1);

        log.info(result.toString());

    }
}
