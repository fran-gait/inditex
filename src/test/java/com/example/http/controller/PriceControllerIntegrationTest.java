package com.example.http.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    private static final String URL_FORMAT = "/prices?currentTime=%s&brandId=%s&productId=%s";
    private static final int BRAND_ID = 1;
    private static final int PRODUCT_ID = 35455;

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("testCases")
    void getPriceTests(LocalDateTime currentTime, String expectedBody) throws Exception {
        mockMvc.perform(get(getUrlTemplate(currentTime)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedBody));
    }

    @Test
    void getPriceWhenNotFound() throws Exception {
        LocalDateTime currentTime = LocalDateTime.of(2023, 8, 19, 10, 0, 0);
        String urlTemplate = getUrlTemplate(currentTime);

        mockMvc.perform(get(urlTemplate).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Test case 1
                arguments(
                        LocalDateTime.of(2020, 6, 14, 10, 0, 0),
                        "{\"productId\": 35455, \"brandId\": 1, \"priceList\": 1, \"startDate\": \"2020-06-14T00:00:00\"," +
                                " \"endDate\": \"2020-12-31T23:59:59\", \"price\": 35.5}"
                ),
                // Test case 2
                arguments(
                        LocalDateTime.of(2020, 6, 14, 16, 0, 0),
                        "{\"productId\": 35455, \"brandId\": 1, \"priceList\": 2, \"startDate\": \"2020-06-14T15:00:00\"," +
                                " \"endDate\": \"2020-06-14T18:30:00\", \"price\": 25.45}"
                ),
                // Test case 3
                arguments(
                        LocalDateTime.of(2020, 6, 14, 21, 0, 0),
                        "{\"productId\": 35455, \"brandId\": 1, \"priceList\": 1, \"startDate\": \"2020-06-14T00:00:00\"," +
                                " \"endDate\": \"2020-12-31T23:59:59\", \"price\": 35.5}"
                ),
                // Test case 4
                arguments(
                        LocalDateTime.of(2020, 6, 15, 10, 0, 0),
                        "{\"productId\": 35455, \"brandId\": 1, \"priceList\": 3, \"startDate\": \"2020-06-15T00:00:00\"," +
                                " \"endDate\": \"2020-06-15T11:00:00\", \"price\": 30.5}"
                ),
                // Test case 5
                arguments(
                        LocalDateTime.of(2020, 6, 16, 21, 0, 0),
                        "{\"productId\": 35455, \"brandId\": 1, \"priceList\": 4, \"startDate\": \"2020-06-15T16:00:00\"," +
                                " \"endDate\": \"2020-12-31T23:59:59\", \"price\": 38.95}"
                )
        );
    }

    private static String getUrlTemplate(LocalDateTime currentTime) {
        return String.format(URL_FORMAT, currentTime, BRAND_ID, PRODUCT_ID);
    }
}