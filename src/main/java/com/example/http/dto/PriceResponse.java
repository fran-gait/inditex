package com.example.http.dto;

import com.example.core.use_case.GetPrice;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class PriceResponse {
    @JsonProperty("productId")
    private int productId;
    @JsonProperty("brandId")
    private int brandId;
    @JsonProperty("priceList")
    private int priceList;
    @JsonProperty("startDate")
    private LocalDateTime startDate;
    @JsonProperty("endDate")
    private LocalDateTime endDate;
    @JsonProperty("price")
    private float price;

    public PriceResponse(GetPrice.Response response) {
        this.productId = response.getProductId();
        this.brandId = response.getBrandId();
        this.priceList= response.getPriceList();
        this.startDate = response.getStartDate();
        this.endDate = response.getEndDate();
        this.price = response.getPrice();
    }
}
