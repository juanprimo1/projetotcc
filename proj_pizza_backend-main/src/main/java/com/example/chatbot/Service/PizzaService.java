package com.example.chatbot.Service;

import com.example.chatbot.Model.DTO.PizzaDTO;
import com.example.chatbot.Model.Pizza;
import com.example.chatbot.Repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public Pizza create (PizzaDTO pizza){
        Pizza newPizza = new Pizza();
        newPizza.setDataCriacao(new Date());
        newPizza.setNomePizza(pizza.getNomePizza());
        newPizza.setIngredientes(pizza.getIngredientes());
        newPizza.setValorPizza(pizza.getValorPizza());
        if (pizza.getNomePizza() == null || pizza.getValorPizza() == null)
            throw new RuntimeException("Campos obrigatórios nulos!");

        if (pizza.getImagem() != null)
            newPizza.setImagem(Base64.getMimeDecoder().decode(pizza.getImagem()));

        return pizzaRepository.save(newPizza);
    }

    public List<PizzaDTO> findAllPizzas() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaDTO> dtos = new ArrayList<>();

        for (var pizza: pizzas) {
            dtos.add(new PizzaDTO(
                    pizza.getCodigoPizza(),
                    pizza.getNomePizza(),
                    pizza.getIngredientes(),
                    pizza.getDataCriacao(),
                    pizza.getValorPizza(),
                    pizza.getImagem() != null ? Base64.getMimeEncoder().encodeToString(pizza.getImagem()) : null
            ));
        }

        return dtos;
    }

    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
