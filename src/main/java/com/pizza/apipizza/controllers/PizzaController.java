package com.pizza.apipizza.controllers;

import com.pizza.apipizza.dto.PizzaDto;
import com.pizza.apipizza.entity.Pizza;
import com.pizza.apipizza.repository.PizzaRepository;
import com.pizza.apipizza.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizza")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<PizzaDto> create(@RequestBody PizzaDto pizzaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaService.save(pizzaDto));
    }

    @GetMapping
    public ResponseEntity<List<PizzaDto>> findAll() {
        List<PizzaDto> pizzaDto = pizzaService.findAll();
        if(pizzaDto.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pizzaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDto> findById(@PathVariable Integer id) {
        PizzaDto pizza = pizzaService.findById(id);
        if (pizza != null)
            return ResponseEntity.ok(pizza);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> update(@PathVariable Integer id, @RequestBody PizzaDto pizzaDto) {
        PizzaDto pizza = pizzaService.update(id, pizzaDto);
        if (pizza != null)
            return ResponseEntity.ok(pizza);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pizzaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
