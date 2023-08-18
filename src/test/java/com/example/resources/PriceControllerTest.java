/*
package com.example.resources;

import com.example.core.domain.Price;
import com.example.core.output.PriceService;
import com.example.http.resources.PriceMapper;
import com.example.http.resources.controller.PriceController;
import com.example.http.resources.dto.PriceResponse;
import com.example.exceptions.ResourceNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private PriceService priceService;
    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceController priceController;

    @Test
    public void shouldReturnOK() {
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
        PriceResponse priceResponse = PriceResponse.builder()
                .id(1L)
                .brandId(1)
                .startDate(localDateTime.minusDays(1))
                .endDate(localDateTime.plusDays(1))
                .productId(35455)
                .price(35.50F)
                .build();
        int productId = 1;
        int brandId = 1;
        when(priceService.findPrice(eq(localDateTime), eq(productId), eq(brandId))).thenReturn(price);
        when(priceMapper.convertDomainToResponse(eq(price))).thenReturn(priceResponse);

        PriceResponse actual = priceController.getPrice(localDateTime, 1, 1);

        verify(priceService, times(1)).findPrice(eq(localDateTime), eq(productId), eq(brandId));
        verify(priceMapper, times(1)).convertDomainToResponse(eq(price));
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals(1, actual.getBrandId());
        assertEquals(localDateTime.minusDays(1), actual.getStartDate());
        assertEquals(localDateTime.plusDays(1), actual.getEndDate());
        assertEquals(35455, actual.getProductId());
        assertEquals(35.50F, actual.getPrice());
    }

    @Test
    public void shouldReturnNotFoundWhenInvalidParams() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int productId = 1;
        int brandId = 1;
        when(priceService.findPrice(eq(localDateTime), eq(productId), eq(brandId))).thenThrow(ResourceNotFound.class);

        try {
            priceController.getPrice(localDateTime, productId, brandId);
            fail();
        } catch (Exception ex) {
            verify(priceService, times(1)).findPrice(eq(localDateTime), eq(productId), eq(brandId));
            assertEquals(ResourceNotFound.class, ex.getClass());
        }
    }

}
*/
