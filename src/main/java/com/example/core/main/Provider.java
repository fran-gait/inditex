package com.example.core.main;

import com.example.core.use_case.GetPrice;

public class Provider {
    private final Dependencies dependencies;

    public Provider(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public GetPrice getPrice() {
        return new GetPrice(dependencies.priceRepository());
    }
}
