package com.example.http.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPriceWithTest1() throws Exception {
        String body = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"brandId\": 1,\n" +
                "    \"priceList\": 1,\n" +
                "    \"startDate\": \"2020-06-14T00:00:00\",\n" +
                "    \"endDate\": \"2020-12-31T23:59:59\",\n" +
                "    \"price\": 35.5\n" +
                "}";
        mockMvc.perform(get("/prices?dateTime=2020-06-14T10:00:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest2() throws Exception {
        String body = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"brandId\": 1,\n" +
                "    \"priceList\": 2,\n" +
                "    \"startDate\": \"2020-06-14T15:00:00\",\n" +
                "    \"endDate\": \"2020-06-14T18:30:00\",\n" +
                "    \"price\": 25.45\n" +
                "}";
        mockMvc.perform(get("/prices?dateTime=2020-06-14T16:00:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest3() throws Exception {
        String body = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"brandId\": 1,\n" +
                "    \"priceList\": 1,\n" +
                "    \"startDate\": \"2020-06-14T00:00:00\",\n" +
                "    \"endDate\": \"2020-12-31T23:59:59\",\n" +
                "    \"price\": 35.5\n" +
                "}";
        mockMvc.perform(get("/prices?dateTime=2020-06-14T21:00:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest4() throws Exception {
        String body = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"brandId\": 1,\n" +
                "    \"priceList\": 3,\n" +
                "    \"startDate\": \"2020-06-15T00:00:00\",\n" +
                "    \"endDate\": \"2020-06-15T11:00:00\",\n" +
                "    \"price\": 30.5\n" +
                "}";
        mockMvc.perform(get("/prices?dateTime=2020-06-15T10:00:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest5() throws Exception {
        String body = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"brandId\": 1,\n" +
                "    \"priceList\": 4,\n" +
                "    \"startDate\": \"2020-06-15T16:00:00\",\n" +
                "    \"endDate\": \"2020-12-31T23:59:59\",\n" +
                "    \"price\": 38.95\n" +
                "}";
        mockMvc.perform(get("/prices?dateTime=2020-06-16T21:00:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }
}