package com.pizza.apipizza.services;

import com.pizza.apipizza.dto.PizzaDto;
import com.pizza.apipizza.entity.Pizza;
import com.pizza.apipizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaDto save(PizzaDto pizzaDto) {
        Pizza pizza = Pizza.builder()
                .pizzaName(pizzaDto.getPizzaName())
                .pizzaOrigin(pizzaDto.getPizzaOrigin())
                .pizzaDescription(pizzaDto.getPizzaDescription())
                .build();
        return convertToDto(pizzaRepository.save(pizza));
    }

    public List<PizzaDto> findAll() {
        return StreamSupport.stream(pizzaRepository.findAll().spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PizzaDto findById(Integer id) {
        return pizzaRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new NoSuchElementException("Id not found"));
    }

    public Pizza update(Integer id, PizzaDto pizzaDto) {
        Pizza existingPizzaId= pizzaRepository.findById(id).get();
        if(existingPizzaId != null) {
            return Pizza.builder()
                    .pizzaId(existingPizzaId.getPizzaId())
                    .pizzaName(pizzaDto.getPizzaName())
                    .pizzaOrigin(pizzaDto.getPizzaOrigin())
                    .pizzaDescription(pizzaDto.getPizzaDescription())
                    .build();
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        pizzaRepository.deleteById(id);
    }


    public PizzaDto convertToDto(Pizza pizza) {
        return PizzaDto.builder()
                .pizzaId(pizza.getPizzaId())
                .pizzaName(pizza.getPizzaName())
                .pizzaOrigin(pizza.getPizzaOrigin())
                .pizzaDescription(pizza.getPizzaDescription())
                .build();
    }




}
