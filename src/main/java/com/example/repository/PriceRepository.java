package com.example.repository;

import com.example.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    List<PriceEntity> findPriceByProductIdAndBrandId(final Integer productId, final Integer brandId);
}
