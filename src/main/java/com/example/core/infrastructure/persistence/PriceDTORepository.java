package com.example.core.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceDTORepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p " +
            "FROM PriceEntity p " +
            "WHERE p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND :currentTime BETWEEN p.startDate AND p.endDate")
    List<PriceEntity> findPricesByProductIdAndBrandIdAndCurrentTime(
            int productId,
            int brandId,
            LocalDateTime currentTime
    );
}
