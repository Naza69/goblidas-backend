package com.example.goblidas_backend.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Data
public class CartItemDTO {

    private String name;
    private int quantity;
    private BigDecimal price;
}
