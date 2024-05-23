package com.pizza.apipizza.services;

import com.pizza.apipizza.dto.PizzaIngredientDto;
import com.pizza.apipizza.entity.Ingredient;
import com.pizza.apipizza.entity.Pizza;
import com.pizza.apipizza.entity.PizzaIngredient;
import com.pizza.apipizza.repository.IngredientRepository;
import com.pizza.apipizza.repository.PizzaIngredientRepository;
import com.pizza.apipizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PizzaIngredientService {

    private final PizzaIngredientRepository pizzaIngredientRepository;
    private  final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;


    public PizzaIngredientDto save(PizzaIngredientDto pizzaIngredientDto){

        Optional<Pizza> pizzaById = pizzaRepository.findById(pizzaIngredientDto.getPizza().getPizzaId());
        Optional<Ingredient> ingredientById = ingredientRepository.findById(pizzaIngredientDto.getIngredient().getIdIngredient());

        if(pizzaById.isPresent() && ingredientById.isPresent()){
            PizzaIngredient pizzaIngredient = PizzaIngredient.builder()
                    .pizza(pizzaById.get())
                    .ingredient(ingredientById.get())
                    .build();

            pizzaIngredient = pizzaIngredientRepository.save(pizzaIngredient);

            return mapToDto(pizzaIngredient);
        }

        throw new IllegalArgumentException("Pizza or Ingredient not found");

    }

    public List<PizzaIngredientDto> findAll(){
        return StreamSupport.stream(pizzaIngredientRepository.findAll().spliterator(),false)
                .map(this::mapToDto)
                .toList();
    }

    

    public PizzaIngredientDto mapToDto(PizzaIngredient pizzaIngredient){
        return PizzaIngredientDto.builder()
                .id(pizzaIngredient.getId())
                .pizza(pizzaIngredient.getPizza())
                .ingredient(pizzaIngredient.getIngredient())
                .build();
    }
}
