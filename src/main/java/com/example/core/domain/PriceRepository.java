package com.example.core.domain;

import java.util.List;

public interface PriceRepository {

    List<Price> findPriceByProductIdAndBrandId(int productId, int brandId);
}
