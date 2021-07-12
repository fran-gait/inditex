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
                        .brandId(domain.getBrandId())
                        .startDate(domain.getStartDate())
                        .endDate(domain.getEndDate())
                        .productId(domain.getProductId())
                        .priority(domain.getPriority())
                        .price(domain.getPrice())
                        .build())
                .orElse(null);
    }
}
