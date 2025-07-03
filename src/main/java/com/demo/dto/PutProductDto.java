package com.demo.dto;

import java.math.BigDecimal;

public record PutProductDto(
        String name,
        BigDecimal price,
        String description
) {
}
