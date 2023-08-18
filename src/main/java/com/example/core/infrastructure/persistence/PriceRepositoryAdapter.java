package com.example.core.infrastructure.persistence;

import com.example.core.domain.Price;
import com.example.core.domain.PriceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("priceRepository")
public class PriceRepositoryAdapter implements PriceRepository {

    private final PriceDTORepository priceRepository;
    private final PriceRepositoryMapper priceRepositoryMapper;

    public PriceRepositoryAdapter(
            PriceDTORepository priceRepository,
            PriceRepositoryMapper priceRepositoryMapper
    ) {
        this.priceRepository = priceRepository;
        this.priceRepositoryMapper = priceRepositoryMapper;
    }

    @Override
    public List<Price> findPriceByProductIdAndBrandId(int productId, int brandId) {
        return priceRepositoryMapper.convertEntityToDomain(
                priceRepository.findPriceByProductIdAndBrandId(productId, brandId)
        );
    }
}
