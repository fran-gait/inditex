package com.example.core.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceDTORepository extends JpaRepository<PriceEntity, Long> {

    List<PriceEntity> findPriceByProductIdAndBrandId(int productId, int brandId);
}
