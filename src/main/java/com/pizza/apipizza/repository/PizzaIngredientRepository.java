package com.pizza.apipizza.repository;

import com.pizza.apipizza.entity.Pizza;
import com.pizza.apipizza.entity.PizzaIngredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaIngredientRepository extends CrudRepository<PizzaIngredient, Integer> {

    List<PizzaIngredient> findByPizza(Pizza pizza);
}
