package com.pizza.apipizza.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pizzaId;
    @Column(name = "pizza_name", nullable = false)
    private String pizzaName;
    @Column(name = "pizza_origin", nullable = false)
    private String pizzaOrigin;
    @Column(name = "pizza_description", nullable = false)
    private String pizzaDescription;
}
