package com.pizza.apipizza.services;

import com.pizza.apipizza.dto.PizzaDto;
import com.pizza.apipizza.entity.Pizza;
import com.pizza.apipizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaDto save(Pizza pizza) {

        return PizzaDto.builder()
                .pizzaName(pizza.getPizzaName())
                .pizzaOrigin(pizza.getPizzaOrigin())
                .pizzaDescription(pizza.getPizzaDescription())
                .build();
    }

    public List<PizzaDto> findAll() {
        return (List) pizzaRepository.findAll();
    }

    public PizzaDto findById(Integer id) {
        return pizzaRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new NoSuchElementException("Id not found"));
    }

    public PizzaDto mapToDto(Pizza pizza) {
        return PizzaDto.builder()
                .pizzaName(pizza.getPizzaName())
                .pizzaOrigin(pizza.getPizzaOrigin())
                .pizzaDescription(pizza.getPizzaDescription())
                .build();
    }
}
