package com.example.chatgptdemo.service;

import com.example.chatgptdemo.util.PDFUtils;
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
 * @time 16:53
 */
@Slf4j
@SpringBootTest
class SummarizationServiceTest
{
    @Autowired
    private SummarizationService summarizationService;

    @Test
    void summarize() throws IOException
    {
        String content = PDFUtils.readPdfContent("classpath:test.pdf");

        String result = summarizationService.summarize(content);

        assertThat(result).isNotBlank();

        log.info(result);
    }
}
