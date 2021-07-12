package com.example.repository;

import com.example.business.domain.Price;
import com.example.business.input.PriceRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceRepository priceRepository;
    private final PriceRepositoryMapper priceRepositoryMapper;

    public PriceRepositoryAdapter(PriceRepository priceRepository, PriceRepositoryMapper priceRepositoryMapper) {
        this.priceRepository = priceRepository;
        this.priceRepositoryMapper = priceRepositoryMapper;
    }

    @Override
    public List<Price> findPriceBy(int productId, int brandId) {
        return priceRepositoryMapper.convertEntityToDomain(
                priceRepository.findPriceByProductIdAndBrandId(productId, brandId)
        );
    }
}
