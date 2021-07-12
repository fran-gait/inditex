package com.example.business.output;

import com.example.business.domain.Price;

import java.time.LocalDateTime;

public interface PriceService {

    Price findPrice(LocalDateTime date, int productId, int brandId);
}
