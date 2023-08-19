package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PriceNotFound extends RuntimeException {

    private static final String NOT_FOUND_FORMAT = "Don't find price with productId %s and brandId %s";

    public PriceNotFound(int productId, int brandId) {
        super(format(NOT_FOUND_FORMAT, productId, brandId));
    }
}
