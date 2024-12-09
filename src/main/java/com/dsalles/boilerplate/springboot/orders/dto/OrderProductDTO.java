package com.dsalles.boilerplate.springboot.orders.dto;

public record OrderProductDTO(
        Long id,
        Long orderId,
        Long productId,
        int quantity
) {
}
