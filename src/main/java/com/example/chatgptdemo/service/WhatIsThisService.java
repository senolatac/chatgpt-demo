package com.example.chatgptdemo.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sa
 * @date 10.04.2023
 * @time 11:52
 */
@Service
@RequiredArgsConstructor
public class WhatIsThisService
{
    private final ChatgptService chatgptService;

    public String whatIsThis(String url)
    {
        String message = String.format("What is this %s", url);

        return chatgptService.sendMessage(message);
    }

    public String whatIsThisPlant(String url)
    {
        String message = String.format("What is this plant %s.", url);

        return chatgptService.sendMessage(message);
    }

    public String whereIsThisPlace(String url)
    {
        String message = String.format("Where is this place %s.", url);

        return chatgptService.sendMessage(message);
    }
}
