package com.example.repository;

import com.example.business.domain.Price;
import com.example.repository.entity.PriceEntity;
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
                            .startDate(priceEntity.getStartDate())
                            .endDate(priceEntity.getEndDate())
                            .productId(priceEntity.getProductId())
                            .priority(priceEntity.getPriority())
                            .price(priceEntity.getPrice())
                            .curr(priceEntity.getCurr()).build());
        });
        return priceList;
    }
}
