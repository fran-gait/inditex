package com.example.core.use_case;

import com.example.core.domain.Price;
import com.example.core.domain.PriceRepository;
import com.example.exception.PriceNotFound;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class GetPrice {
    PriceRepository priceRepository;

    public GetPrice(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Response execute(Request request) {
        List<Price> priceList = priceRepository.findPriceByProductIdAndBrandId(
                request.getProductId(),
                request.getBrandId()
        );

        Price maxPriceByPriority = getMaxPriceByPriority(request, priceList);
        return generatePriceResponse(maxPriceByPriority);
    }

    private Price getMaxPriceByPriority(Request request, List<Price> priceList) {
        return priceList.stream()
                .filter(price -> price.isPriceBetweenDate(request.getCurrentTime()))
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> new PriceNotFound(request.getProductId(), request.getBrandId()));
    }

    private Response generatePriceResponse(Price price) {
        return new Response(
                price.getBrandId(),
                price.getProductId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }

    @Getter
    @AllArgsConstructor
    public static class Request {
        private LocalDateTime currentTime;
        private int productId;
        private int brandId;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int brandId;
        private int productId;
        private int priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private float price;
    }
}
