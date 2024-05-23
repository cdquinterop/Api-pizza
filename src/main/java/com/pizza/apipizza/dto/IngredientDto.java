package com.pizza.apipizza.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientDto {

    private Integer idIngredient;

    private String  nameIngredient;

    private Integer caloriesIngredient;
}
