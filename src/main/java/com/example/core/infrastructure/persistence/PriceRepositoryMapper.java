package com.example.core.infrastructure.persistence;

import com.example.core.domain.Price;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceRepositoryMapper {

    public List<Price> convertEntityToDomain(List<PriceEntity> priceEntityList) {
        return priceEntityList.stream()
                .map(priceEntity -> Price.builder()
                        .id(priceEntity.getId())
                        .brandId(priceEntity.getBrandId())
                        .productId(priceEntity.getProductId())
                        .priceList(priceEntity.getPriceList())
                        .startDate(priceEntity.getStartDate())
                        .endDate(priceEntity.getEndDate())
                        .priority(priceEntity.getPriority())
                        .price(priceEntity.getPrice())
                        .currency(priceEntity.getCurr()).build())
                .collect(Collectors.toList());
    }
}
