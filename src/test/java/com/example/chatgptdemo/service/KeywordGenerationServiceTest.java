package com.example.chatgptdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sa
 * @date 10.04.2023
 * @time 11:44
 */
@Slf4j
@SpringBootTest
class KeywordGenerationServiceTest
{
    private static final String KEYWORD = "Spotify";

    @Autowired
    private KeywordGenerationService keywordGenerationService;

    @Test
    void generateSynonyms()
    {
        String result = keywordGenerationService.generateSynonyms(KEYWORD);

        assertThat(result).isNotBlank();

        log.info(result);
    }
}
