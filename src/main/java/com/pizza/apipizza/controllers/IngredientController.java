package com.pizza.apipizza.controllers;

import com.pizza.apipizza.dto.IngredientDto;
import com.pizza.apipizza.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingredient/")
public class IngredientController {

    private final IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<IngredientDto> createINgredient(@RequestBody IngredientDto ingredientDto){

        IngredientDto saveIngredient = ingredientService.save(ingredientDto);

        return new ResponseEntity<>(saveIngredient, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<IngredientDto> updateIngredient(@PathVariable Integer id, @RequestBody IngredientDto ingredientDto){

        IngredientDto updateIngredient = ingredientService.update(id, ingredientDto);

        if(updateIngredient != null){

            return new ResponseEntity<>(updateIngredient, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllINgredient(){
        List<IngredientDto> ingredientDtos = ingredientService.findAll();
        return new ResponseEntity<>(ingredientDtos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable Integer id){
        IngredientDto ingredientDto = ingredientService.findById(id);
        if(ingredientDto != null){
            return new ResponseEntity<>(ingredientDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping
    public ResponseEntity<Void>deleteIngredientById(@PathVariable Integer id){
        ingredientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
