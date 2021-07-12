package com.example.controller;

import com.example.business.domain.Price;
import com.example.controller.response.PriceResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PriceMapper {

    public PriceResponse convertDomainToResponse(Price price) {
        return Optional.ofNullable(price)
                .map(domain -> PriceResponse.builder()
                        .id(domain.getId())
                        .brandId(domain.getBrandId())
                        .productId(domain.getProductId())
                        .startDate(domain.getStartDate())
                        .endDate(domain.getEndDate())
                        .price(domain.getPrice())
                        .build())
                .orElse(null);
    }
}
