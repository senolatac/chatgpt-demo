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
 * @time 11:55
 */
@Slf4j
@SpringBootTest
class WhatIsThisServiceTest
{
    private static final String KEYWORD = "Spotify";

    @Autowired
    private WhatIsThisService whatIsThisService;

    @Test
    void whatIsThis()
    {
        String url = "https://www.baticim.com.tr/media/cache/product_list/uploads/images/general/26224306fdece50e3afa9882ff96d09dbad3ab0c.png";

        String result = whatIsThisService.whatIsThis(url);

        assertThat(result).isNotBlank();

        log.info(result);
    }

    @Test
    void whatIsThisPlant()
    {
        String url = "https://res.cloudinary.com/dk-find-out/image/upload/q_80,w_960,f_auto/DCTM_Penguin_UK_DK_AL458052_zs2mia.png";

        String result = whatIsThisService.whatIsThisPlant(url);

        assertThat(result).isNotBlank();

        log.info(result);
    }

    @Test
    void whereIsThisPlace()
    {
        String url = "https://upload.wikimedia.org/wikipedia/commons/2/2f/Hollywood_sign_%288485145044%29.jpg";

        String result = whatIsThisService.whereIsThisPlace(url);

        assertThat(result).isNotBlank();

        log.info(result);
    }
}
