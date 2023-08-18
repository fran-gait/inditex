package com.example.core.infrastructure.persistence;

import com.example.core.domain.Price;
import com.example.core.infrastructure.persistence.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceRepositoryMapper {

    public List<Price> convertEntityToDomain(List<PriceEntity> priceEntityList) {
        List<Price> priceList = new ArrayList<>();

        if (null == priceEntityList) {
            return null;
        }
        priceEntityList.forEach(priceEntity -> {
            priceList.add(
                    Price.builder()
                            .id(priceEntity.getId())
                            .brandId(priceEntity.getBrandId())
                            .productId(priceEntity.getProductId())
                            .startDate(priceEntity.getStartDate())
                            .endDate(priceEntity.getEndDate())
                            .priority(priceEntity.getPriority())
                            .price(priceEntity.getPrice())
                            .curr(priceEntity.getCurr()).build());
        });
        return priceList;
    }
}
