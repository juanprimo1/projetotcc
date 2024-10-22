package com.example.chatbot.Service;

import com.example.chatbot.Model.Pizza;
import com.example.chatbot.Repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public Pizza create (Pizza pizza){
        Pizza newPizza = new Pizza();
        newPizza.setDataCriacao(new Date());
        newPizza.setNomePizza(pizza.getNomePizza());
        newPizza.setIngredientes(pizza.getIngredientes());
        newPizza.setValorPizza(pizza.getValorPizza());
        if (pizza.getNomePizza() == null || pizza.getValorPizza() == null)
            throw new RuntimeException("Campos obrigatórios nulos!");

        return pizzaRepository.save(newPizza);
    }

    public List<Pizza> findAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

}
