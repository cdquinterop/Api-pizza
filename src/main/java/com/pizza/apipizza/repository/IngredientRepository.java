package com.pizza.apipizza.repository;

import com.pizza.apipizza.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository  extends CrudRepository<Ingredient,Integer> {
}
