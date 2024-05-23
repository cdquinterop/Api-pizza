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

    @PutMapping("/{id}")
    public ResponseEntity<PizzaIngredientDto> updatePizzaIngredient(@PathVariable Integer id, @RequestBody PizzaIngredientDto pizzaIngredientDto){

        PizzaIngredientDto updatePizzaIngredienDto = pizzaIngredientService.update(id,pizzaIngredientDto);

        if(updatePizzaIngredienDto != null){

            return new ResponseEntity<>(updatePizzaIngredienDto,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }


    @GetMapping
    public ResponseEntity<List<PizzaIngredientDto>> findAll(){

        List<PizzaIngredientDto> pizzaIngredientDto = pizzaIngredientService.findAll();

        return new ResponseEntity<>(pizzaIngredientDto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaIngredientDto>  findById(@PathVariable Integer id){

        PizzaIngredientDto existingPizzaIngredient = pizzaIngredientService.findById(id);

        if(existingPizzaIngredient != null){
            return new ResponseEntity<>(existingPizzaIngredient, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/pizza/{id}")
    public ResponseEntity<List<PizzaIngredientDto>> findByIdPizza(@PathVariable Integer id){

        List<PizzaIngredientDto> ingredientDtos = pizzaIngredientService.findIngredientsByPizzaId(id);

        if(ingredientDtos != null){
            return new ResponseEntity<>(ingredientDtos,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById( @PathVariable Integer id){

        pizzaIngredientService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
