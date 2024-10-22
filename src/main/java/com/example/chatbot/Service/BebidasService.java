package com.example.chatbot.Service;

import com.example.chatbot.Model.Bebidas;
import com.example.chatbot.Repository.BebidasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BebidasService {

    private final BebidasRepository bebidasRepository;

    public Bebidas create (Bebidas bebidas) {

        if (bebidasRepository.findByBebida(bebidas.getBebida()) != null) {
            throw new RuntimeException("Bebida já cadastrada!");
        }

        return bebidasRepository.save(bebidas);
    }

    public List<Bebidas> getBebidas() {
        return bebidasRepository.findAll();
    }

    public Bebidas findById(Long id) {
        return bebidasRepository.findById(id).orElse(null);
    }
}
