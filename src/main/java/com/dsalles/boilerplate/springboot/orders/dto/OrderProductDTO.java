package com.dsalles.boilerplate.springboot.orders.dto;

import jakarta.validation.constraints.NotNull;

public record OrderProductDTO(
        @NotNull(message = "Product ID is mandatory")
        Long productId,
        @NotNull(message = "Quantity is mandatory")
        int quantity
) {
}
