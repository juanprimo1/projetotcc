package com.example.chatbot.Controller;

import com.example.chatbot.Model.DTO.PizzaDTO;
import com.example.chatbot.Model.Pizza;
import com.example.chatbot.Service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pizza")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping("")
    public ResponseEntity<Object> cadastrarPizza(@RequestBody PizzaDTO pizza) {
        return new ResponseEntity<>(pizzaService.create(pizza), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PizzaDTO>> getPizzas() {
        return new ResponseEntity<>(pizzaService.findAllPizzas(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pizza> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(pizzaService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        pizzaService.deletePizza(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
