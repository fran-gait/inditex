package com.example.repository;

import com.example.business.domain.Price;
import com.example.repository.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryMapperTest {

    @InjectMocks
    private PriceRepositoryMapper priceRepositoryMapper;

    @Test
    public void shouldReturnPrice() {
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

        List<Price> actual = priceRepositoryMapper.convertEntityToDomain(priceEntityList);
        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals(1L, actual.get(0).getId());
        assertEquals(1, actual.get(0).getBrandId());
        assertEquals(localDateTime.minusDays(1), actual.get(0).getStartDate());
        assertEquals(localDateTime.plusDays(1), actual.get(0).getEndDate());
        assertEquals(35455, actual.get(0).getProductId());
        assertEquals(0, actual.get(0).getPriority());
        assertEquals(35.50F, actual.get(0).getPrice());
        assertEquals("EUR", actual.get(0).getCurr());

        assertEquals(2L, actual.get(1).getId());
        assertEquals(1, actual.get(1).getBrandId());
        assertEquals(localDateTime.minusDays(1), actual.get(1).getStartDate());
        assertEquals(localDateTime.plusDays(1), actual.get(1).getEndDate());
        assertEquals(35455, actual.get(1).getProductId());
        assertEquals(1, actual.get(1).getPriority());
        assertEquals(25.45F, actual.get(1).getPrice());
        assertEquals("EUR", actual.get(1).getCurr());
    }

    @Test
    public void shouldReturnNull() {
        List<Price> actual = priceRepositoryMapper.convertEntityToDomain(null);
        assertNull(actual);
    }
}