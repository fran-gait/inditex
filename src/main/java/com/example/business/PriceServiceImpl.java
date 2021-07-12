package com.example.business;

import com.example.business.domain.Price;
import com.example.business.input.PriceRepositoryPort;
import com.example.business.output.PriceService;
import com.example.exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.format;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepositoryPort priceRepositoryPort;

    public PriceServiceImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Price findPrice(final LocalDateTime localDateTime, final int productId, final int brandId) {

        List<Price> priceList = priceRepositoryPort.findPriceBy(productId, brandId);

        return priceList.stream()
                .filter(price -> localDateTime.isAfter(price.getStartDate()) &&
                        localDateTime.isBefore(price.getEndDate()))
                .sorted(Comparator.comparingInt(Price::getPriority).reversed())
                .findFirst()
                .orElseThrow(() -> new ResourceNotFound(
                        format("Dont find price with productId %s and brandId %s", productId, brandId)));

    }
}
