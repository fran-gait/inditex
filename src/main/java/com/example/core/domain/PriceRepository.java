package com.example.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findPricesByProductIdAndBrandIdAndCurrentTime(
            int productId,
            int brandId,
            LocalDateTime currentTime
    );
}
