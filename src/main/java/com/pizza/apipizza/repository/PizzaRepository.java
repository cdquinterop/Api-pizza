package com.pizza.apipizza.repository;

import com.pizza.apipizza.entity.Pizza;
import org.springframework.data.repository.CrudRepository;


public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

}
