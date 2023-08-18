package com.example.http.resources.controller;

import com.example.core.main.Provider;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Response> getPrice(
            @RequestParam("localDateTime") LocalDateTime localDateTime,
            @RequestParam("productId") int productId,
            @RequestParam("brandId") int brandId
    ) {
        Request request = new Request(localDateTime, productId, brandId);
        Response response = provider.getPrice().execute(request);

        return ResponseEntity.ok(response);
    }
}
