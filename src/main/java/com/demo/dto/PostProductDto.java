package com.demo.dto;

import java.math.BigDecimal;

public record PostProductDto(
        String name,
        BigDecimal price,
        String description
) {
}
