package com.example.core.infrastructure.persistence;

import com.example.core.domain.Price;

import java.util.List;

public interface PriceRepositoryPort {

    List<Price> findPriceByProductIdAndBrandId(int productId, int brandId);
}
