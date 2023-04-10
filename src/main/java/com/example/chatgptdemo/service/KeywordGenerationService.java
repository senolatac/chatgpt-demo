package com.example.chatgptdemo.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sa
 * @date 10.04.2023
 * @time 11:38
 */
@Service
@RequiredArgsConstructor
public class KeywordGenerationService
{
    private final ChatgptService chatgptService;

    public String generateSynonyms(String keyword)
    {
        String message = String.format("Generate 3 synonyms of keyword \"%s\".", keyword);

        return chatgptService.sendMessage(message);
    }
}
