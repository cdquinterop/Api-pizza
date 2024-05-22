package com.pizza.apipizza.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PizzaDto {
    private Integer pizzaId;
    private String pizzaName;
    private String pizzaOrigin;
    private String pizzaDescription;
}
