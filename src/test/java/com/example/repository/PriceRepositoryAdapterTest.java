package com.example.repository;

import com.example.business.domain.Price;
import com.example.repository.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryAdapterTest {

    @Mock
    private PriceRepository priceRepository;
    @Mock
    private PriceRepositoryMapper priceRepositoryMapper;

    @InjectMocks
    private PriceRepositoryAdapter priceRepositoryAdapter;

    @Test
    public void shouldReturnPriceList() {
        LocalDateTime localDateTime = LocalDateTime.now();
        PriceEntity priceEntity1 = PriceEntity.builder()
                .id(1L)
                .brandId(1)
                .startDate(localDateTime.minusDays(1))
                .endDate(localDateTime.plusDays(1))
                .productId(35455)
                .priority(0)
                .price(35.50F)
                .curr("EUR")
                .build();
        PriceEntity priceEntity2 = PriceEntity.builder()
                .id(2L)
                .brandId(1)
                .startDate(localDateTime.minusDays(1))
                .endDate(localDateTime.plusDays(1))
                .productId(35455)
                .priority(1)
                .price(25.45F)
                .curr("EUR")
                .build();
        List<PriceEntity> priceEntityList = new ArrayList<>();
        priceEntityList.add(priceEntity1);
        priceEntityList.add(priceEntity2);
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
        Price price2 = Price.builder()
                .id(2L)
                .brandId(1)
                .startDate(localDateTime.minusDays(1))
                .endDate(localDateTime.plusDays(1))
                .productId(35455)
                .priority(1)
                .price(25.45F)
                .curr("EUR")
                .build();
        List<Price> priceList = new ArrayList<>();
        priceList.add(price);
        priceList.add(price2);
        int productId = 1;
        int brandId = 1;
        when(priceRepository.findPriceByProductIdAndBrandId(eq(productId), eq(brandId))).thenReturn(priceEntityList);
        when(priceRepositoryMapper.convertEntityToDomain(eq(priceEntityList))).thenReturn(priceList);

        List<Price> actual = priceRepositoryAdapter.findPriceBy(1, 1);

        verify(priceRepository, times(1)).findPriceByProductIdAndBrandId(eq(productId), eq(brandId));
        verify(priceRepositoryMapper, times(1)).convertEntityToDomain(eq(priceEntityList));
        assertNotNull(actual);
        assertEquals(price, actual.get(0));
        assertEquals(price2, actual.get(1));
    }

    @Test
    public void shouldReturnNullList() {
        int productId = 1;
        int brandId = 1;
        when(priceRepository.findPriceByProductIdAndBrandId(eq(productId), eq(brandId))).thenReturn(null);
        when(priceRepositoryMapper.convertEntityToDomain(eq(null))).thenReturn(null);

        List<Price> actual = priceRepositoryAdapter.findPriceBy(1, 1);

        verify(priceRepository, times(1)).findPriceByProductIdAndBrandId(eq(productId), eq(brandId));
        assertNull(actual);
    }
}
