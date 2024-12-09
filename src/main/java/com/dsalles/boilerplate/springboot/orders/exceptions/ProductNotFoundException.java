package com.dsalles.boilerplate.springboot.orders.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
