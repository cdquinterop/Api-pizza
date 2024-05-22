package com.pizza.apipizza.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Integer idIngredient;

    @Column(name = "name_ingredient", nullable = false)
    private String  nameIngredient;

    @Column(name = "calories_ingredient", nullable = false)
    private Integer caloriesIngredient;
}
