package com.example.chatgptdemo.service;

import io.github.flashvayne.chatgpt.dto.image.ImageFormat;
import io.github.flashvayne.chatgpt.dto.image.ImageSize;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sa
 * @date 10.04.2023
 * @time 12:34
 */
@Service
@RequiredArgsConstructor
public class ImageGenerationService
{
    private final ChatgptService chatgptService;

    public List<String> generateImageFromText(String prompt)
    {
        return chatgptService.imageGenerate(prompt, 1, ImageSize.SMALL, ImageFormat.URL);
    }

    public List<String> generateImageFromUrl(String url)
    {
        String message = String.format("create a random image using this url \"%s\"", url);

        return chatgptService.imageGenerate(message, 1, ImageSize.SMALL, ImageFormat.URL);
    }
}
