package com.dsalles.boilerplate.springboot.orders.dto;

import jakarta.validation.constraints.NotNull;

public record OrderProductDTO(
        @NotNull(message = "Product ID is mandatory")
        String productId,
        @NotNull(message = "Quantity is mandatory")
        int quantity
) {
}
