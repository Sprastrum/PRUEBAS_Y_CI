package com.unisabana.software.tienda.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public class StockControllerTest {
    private static final String PATH_SAVE_STOCK = "/stock/saveStock";
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void Given_A_Stock_When_Invoke_save_then_saveStock() {

    }
}