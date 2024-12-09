package com.dsalles.boilerplate.springboot.orders.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO(
        Long id,
        String name,
        String description,
        BigDecimal value,
        List<OrderProductDTO> orderProducts
        ) {
}