package com.example.http.controller;

import com.example.core.main.Provider;
import com.example.http.dto.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.example.core.use_case.GetPrice.*;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final Provider provider;

    @Autowired
    public PriceController(Provider provider) {
        this.provider = provider;
    }

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @RequestParam("productId") int productId,
            @RequestParam("brandId") int brandId
    ) {
        Request request = new Request(dateTime, productId, brandId);
        Response response = provider.getPrice().execute(request);

        return ResponseEntity.ok(new PriceResponse(response));
    }
}
