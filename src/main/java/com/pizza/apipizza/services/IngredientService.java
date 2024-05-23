package com.pizza.apipizza.services;

import com.pizza.apipizza.dto.IngredientDto;
import com.pizza.apipizza.entity.Ingredient;
import com.pizza.apipizza.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientDto save (IngredientDto ingredientDto){

        Ingredient ingredient = Ingredient.builder()
                .nameIngredient(ingredientDto.getNameIngredient())
                .caloriesIngredient(ingredientDto.getCaloriesIngredient())
                .build();

        return mapToDto(ingredientRepository.save(ingredient));
    }

    public IngredientDto update(Integer id, IngredientDto ingredientDto){

        IngredientDto existingIngredient = findById(id);

        if (existingIngredient != null){

            Ingredient ingredient = Ingredient.builder()
                    .idIngredient(existingIngredient.getIdIngredient())
                    .nameIngredient(ingredientDto.getNameIngredient())
                    .caloriesIngredient(ingredientDto.getCaloriesIngredient())
                    .build();
            return mapToDto(ingredientRepository.save(ingredient));
        }else {
            return null;
        }
    }

    public List<IngredientDto> findAll(){
        return StreamSupport.stream(ingredientRepository.findAll().spliterator(),false)
                .map(this::mapToDto)
                .toList();
    }

    public IngredientDto findById(Integer id){
        return ingredientRepository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    public void deleteById(Integer id){
        ingredientRepository.deleteById(id);
    }


    public IngredientDto mapToDto(Ingredient ingredient){
        return IngredientDto.builder()
                .idIngredient(ingredient.getIdIngredient())
                .nameIngredient(ingredient.getNameIngredient())
                .caloriesIngredient(ingredient.getCaloriesIngredient())
                .build();
    }
}
