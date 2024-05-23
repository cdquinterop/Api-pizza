package com.pizza.apipizza.controllers;


import com.pizza.apipizza.dto.PizzaIngredientDto;
import com.pizza.apipizza.services.PizzaIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pizza-ingredient/")
public class PizzaIngredientController {

    private final PizzaIngredientService pizzaIngredientService;

    @PostMapping
    public ResponseEntity<PizzaIngredientDto> save(@RequestBody PizzaIngredientDto pizzaIngredientDto){

        PizzaIngredientDto pizzaIngredientSave = pizzaIngredientService.save(pizzaIngredientDto);

        return new ResponseEntity<>(pizzaIngredientSave, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PizzaIngredientDto>> findAll(){

        List<PizzaIngredientDto> pizzaIngredientDto = pizzaIngredientService.findAll();

        return new ResponseEntity<>(pizzaIngredientDto,HttpStatus.OK);
    }


}
