package com.example.chatgptdemo.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sa
 * @date 10.04.2023
 * @time 16:49
 */
@Service
@RequiredArgsConstructor
public class SummarizationService
{
    private final ChatgptService chatgptService;

    public String summarize(String content)
    {
        String prompt = String.format("Summarize this: %s", content.substring(0, Math.min(content.length(), 300)));

        return chatgptService.sendMessage(prompt);
    }
}
