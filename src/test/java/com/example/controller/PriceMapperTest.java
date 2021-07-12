package com.example.controller;

import com.example.business.domain.Price;
import com.example.controller.response.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceMapperTest {

    @InjectMocks
    private PriceMapper priceMapper;

    @Test
    public void shouldReturnPrice() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Price price = Price.builder()
                .id(1L)
                .brandId(1)
                .startDate(localDateTime.minusDays(1))
                .endDate(localDateTime.plusDays(1))
                .productId(35455)
                .priority(0)
                .price(35.50F)
                .curr("EUR")
                .build();

        PriceResponse actual = priceMapper.convertDomainToResponse(price);
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals(1, actual.getBrandId());
        assertEquals(localDateTime.minusDays(1), actual.getStartDate());
        assertEquals(localDateTime.plusDays(1), actual.getEndDate());
        assertEquals(35455, actual.getProductId());
        assertEquals(35.50F, actual.getPrice());
    }

    @Test
    public void shouldReturnNull() {
        PriceResponse actual = priceMapper.convertDomainToResponse(null);
        assertNull(actual);
    }
}