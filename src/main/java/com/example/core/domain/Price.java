package com.example.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Price {

    private long id;
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private float price;
    private String currency;

    public boolean isPriceBetweenDate(LocalDateTime dateTime) {
        return startDate.isBefore(dateTime) && endDate.isAfter(dateTime);
    }
}
