package com.example.controller;

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
        String body = "{\"id\":1,\"price\":35.5,\"brand_id\":1,\"start_date\":\"2020-06-14T00:00:00\",\"end_date\":\"2020-12-31T23:59:59\",\"product_id\":35455}";
        mockMvc.perform(get("/prices?localDateTime=2020-06-14T10:00:00&brandId=1&productId=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest2() throws Exception {
        String body = "{\"id\":2,\"price\":25.45,\"brand_id\":1,\"start_date\":\"2020-06-14T15:00:00\",\"end_date\":\"2020-06-14T18:30:00\",\"product_id\":35455}";
        mockMvc.perform(get("/prices?localDateTime=2020-06-14T16:00:00&brandId=1&productId=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest3() throws Exception {
        String body = "{\"id\":1,\"price\":35.5,\"brand_id\":1,\"start_date\":\"2020-06-14T00:00:00\",\"end_date\":\"2020-12-31T23:59:59\",\"product_id\":35455}";
        mockMvc.perform(get("/prices?localDateTime=2020-06-14T21:00:00&brandId=1&productId=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest4() throws Exception {
        String body = "{\"id\":3,\"price\":30.50,\"brand_id\":1,\"start_date\":\"2020-06-15T00:00:00\",\"end_date\":\"2020-06-15T11:00:00\",\"product_id\":35455}";
        mockMvc.perform(get("/prices?localDateTime=2020-06-15T10:00:00&brandId=1&productId=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }

    @Test
    void getPriceWithTest5() throws Exception {
        String body = "{\"id\":4,\"price\":38.95,\"brand_id\":1,\"start_date\":\"2020-06-15T16:00:00\",\"end_date\":\"2020-12-31T23:59:59\",\"product_id\":35455}";
        mockMvc.perform(get("/prices?localDateTime=2020-06-16T21:00:00&brandId=1&productId=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(body));
    }
}
