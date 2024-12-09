package com.dsalles.boilerplate.springboot.orders.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO(
        Long id,
        @NotBlank(message = "Name is mandatory")
        @Size(max = 100, message = "Name must be less than 100 characters")
        String name,
        @NotBlank(message = "Description is mandatory")
        String description,
        @NotNull(message = "Value is mandatory")
        BigDecimal value,
        List<OrderProductDTO> orderProducts
) {
}