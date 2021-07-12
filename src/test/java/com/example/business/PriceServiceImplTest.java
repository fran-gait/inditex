package com.example.business;

import com.example.business.domain.Price;
import com.example.business.input.PriceRepositoryPort;
import com.example.exceptions.ResourceNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    public void testShouldReturnPriceWhenLocalDateTimeIfInRange() {
        LocalDateTime localDateTimePrice = LocalDateTime.now();
        Price expected = Price.builder()
                .id(1L)
                .brandId(1)
                .startDate(localDateTimePrice.minusDays(1))
                .endDate(localDateTimePrice.plusDays(1))
                .productId(35455)
                .priority(0)
                .price(35.50F)
                .curr("EUR")
                .build();
        List<Price> priceList = Collections.singletonList(expected);
        int productId = 1;
        int brandId = 1;
        when(priceRepositoryPort.findPriceBy(eq(productId), eq(brandId))).thenReturn(priceList);

        Price actual = priceService.findPrice(localDateTimePrice, productId, brandId);

        verify(priceRepositoryPort, times(1)).findPriceBy(eq(productId), eq(brandId));
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnPriceWhenLocalDateTimeIfInRangeAndAppliedPriority() {
        LocalDateTime localDateTimePrice = LocalDateTime.now();
        Price price1 = Price.builder()
                .id(1L)
                .brandId(1)
                .startDate(localDateTimePrice.minusDays(1))
                .endDate(localDateTimePrice.plusDays(1))
                .productId(35455)
                .priority(0)
                .price(35.50F)
                .curr("EUR")
                .build();
        Price price2 = Price.builder()
                .id(2L)
                .brandId(1)
                .startDate(localDateTimePrice.minusDays(1))
                .endDate(localDateTimePrice.plusDays(1))
                .productId(35455)
                .priority(1)
                .price(25.45F)
                .curr("EUR")
                .build();
        List<Price> priceList = new ArrayList<>();
        priceList.add(price1);
        priceList.add(price2);
        int productId = 1;
        int brandId = 1;
        when(priceRepositoryPort.findPriceBy(eq(productId), eq(brandId))).thenReturn(priceList);

        Price actual = priceService.findPrice(localDateTimePrice, productId, brandId);

        verify(priceRepositoryPort, times(1)).findPriceBy(eq(productId), eq(brandId));
        assertNotNull(actual);
        assertEquals(price2, actual);
    }

    @Test
    public void testShouldReturnExceptionWhenEmptyPrice() {
        LocalDateTime localDateTimePrice = LocalDateTime.now();
        int productId = 1;
        int brandId = 1;

        try {
            priceService.findPrice(localDateTimePrice, productId, brandId);
            fail();
        } catch (Exception ex) {
            verify(priceRepositoryPort, times(1)).findPriceBy(eq(productId), eq(brandId));
            assertEquals(ResourceNotFound.class, ex.getClass());
        }
    }
}