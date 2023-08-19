package com.example.core.infrastructure;

import com.example.core.domain.PriceRepository;
import com.example.core.main.Dependencies;
import org.springframework.stereotype.Service;

@Service
public class SpringDependencies implements Dependencies {
    PriceRepository priceRepository;

    public SpringDependencies(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceRepository priceRepository() {
        return priceRepository;
    }
}
