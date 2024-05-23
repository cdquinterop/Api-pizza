package com.pizza.apipizza.repository;

import com.pizza.apipizza.entity.PizzaIngredient;
import org.springframework.data.repository.CrudRepository;

public interface PizzaIngredientRepository extends CrudRepository<PizzaIngredient, Integer> {
}
