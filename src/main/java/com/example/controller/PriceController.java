package com.example.controller;

import com.example.business.output.PriceService;
import com.example.controller.response.PriceResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;
    private final PriceMapper priceMapper;

    public PriceController(PriceService priceService, PriceMapper priceMapper) {
        this.priceService = priceService;
        this.priceMapper = priceMapper;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public PriceResponse getPrice(@RequestParam("localDateTime")
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime,
                                  @RequestParam("productId") int productId,
                                  @RequestParam("brandId") int brandId) {

        return priceMapper.convertDomainToResponse(
                priceService.findPrice(localDateTime, productId, brandId)
        );
    }
}
