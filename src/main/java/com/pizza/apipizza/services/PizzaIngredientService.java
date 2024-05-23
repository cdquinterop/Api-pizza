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
        }else{
            return null;
        }



    }

    public PizzaIngredientDto update(Integer id, PizzaIngredientDto pizzaIngredientDto){

        PizzaIngredientDto existingPizzaIngredient = findById(id);

        if(existingPizzaIngredient != null){
             PizzaIngredient pizzaIngredient = PizzaIngredient.builder()
                     .id(existingPizzaIngredient.getId())
                     .pizza(pizzaIngredientDto.getPizza())
                     .ingredient(pizzaIngredientDto.getIngredient())
                     .build();

             return mapToDto(pizzaIngredientRepository.save(pizzaIngredient));
        }else {
            return null;
        }
    }

    public List<PizzaIngredientDto> findAll(){
        return StreamSupport.stream(pizzaIngredientRepository.findAll().spliterator(),false)
                .map(this::mapToDto)
                .toList();
    }

    public PizzaIngredientDto findById(Integer id){
        return pizzaIngredientRepository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    public List<PizzaIngredientDto> findIngredientsByPizzaId(Integer id){
        Optional<Pizza> existingPizza = pizzaRepository.findById(id);

        if(existingPizza.isPresent()){
            List<PizzaIngredient> pizzaIngredients =pizzaIngredientRepository.findByPizza(existingPizza.get());
            return pizzaIngredients.stream()
                    .map(this::mapToDto)
                    .toList();
        }else{
            return null;
        }
    }

    public void deleteById(Integer id){
        pizzaIngredientRepository.deleteById(id);
    }

    

    public PizzaIngredientDto mapToDto(PizzaIngredient pizzaIngredient){
        return PizzaIngredientDto.builder()
                .id(pizzaIngredient.getId())
                .pizza(pizzaIngredient.getPizza())
                .ingredient(pizzaIngredient.getIngredient())
                .build();
    }
}
