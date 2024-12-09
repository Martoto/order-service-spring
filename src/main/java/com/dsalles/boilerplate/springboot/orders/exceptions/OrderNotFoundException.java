package com.dsalles.boilerplate.springboot.orders.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
