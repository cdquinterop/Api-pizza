package com.pizza.apipizza.dto;


import com.pizza.apipizza.entity.Ingredient;
import com.pizza.apipizza.entity.Pizza;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PizzaIngredientDto {

    private Integer id;

    private Pizza pizza;

    private Ingredient ingredient;
}
