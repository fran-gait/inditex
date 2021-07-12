package com.example.business.input;

import com.example.business.domain.Price;

import java.util.List;

public interface PriceRepositoryPort {

    List<Price> findPriceBy(int productId, int brandId);
}
