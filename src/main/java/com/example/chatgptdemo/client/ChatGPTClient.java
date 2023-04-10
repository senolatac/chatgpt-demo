package com.example.chatgptdemo.client;

import io.github.flashvayne.chatgpt.dto.image.ImageSize;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author sa
 * @date 10.04.2023
 * @time 13:20
 */
@Service
@RequiredArgsConstructor
public class ChatGPTClient
{
    private final static String IMAGE_EDIT_URL = "https://api.openai.com/v1/images/edits";

    @Value("${chatgpt.api-key}")
    private String OPENAI_API_KEY;

    private final RestTemplate restTemplate;

    public String createImageEditWithOkHttp(String prompt) throws IOException
    {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("image","file",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                ResourceUtils.getFile("classpath:image_edit_original.png")))
                .addFormDataPart("mask","file",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                ResourceUtils.getFile("classpath:image_edit_mask.png")))
                .addFormDataPart("prompt",prompt)
                .addFormDataPart("n","1")
                .addFormDataPart("size", ImageSize.SMALL.getSize())
                .build();
        Request request = new Request.Builder()
                .url(IMAGE_EDIT_URL)
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public String createImageEditWithRestTemplate(String prompt) throws FileNotFoundException
    {
        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(createBody(prompt), commonHttpHeaders());

        ResponseEntity<String> response = restTemplate.postForEntity(IMAGE_EDIT_URL, requestEntity, String.class);

        return response.getBody();
    }



    private MultiValueMap<String, Object> createBody(String prompt) throws FileNotFoundException
    {
        MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();

        body.add("image", new FileSystemResource(ResourceUtils.getFile("classpath:image_edit_original.png")));
        body.add("mask", new FileSystemResource(ResourceUtils.getFile("classpath:image_edit_mask.png")));
        body.add("prompt",prompt);
        body.add("n","1");
        body.add("size", ImageSize.SMALL.getSize());

        return body;
    }

    private HttpHeaders commonHttpHeaders()
    {
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();

        headers.add("Authorization", "Bearer " + OPENAI_API_KEY);
        headers.add("Content-Type", org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE);

        return new HttpHeaders(headers);
    }
}
