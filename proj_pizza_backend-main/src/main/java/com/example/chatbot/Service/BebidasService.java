package com.example.chatbot.Service;

import com.example.chatbot.Model.Bebidas;
import com.example.chatbot.Model.DTO.BebidaDTO;
import com.example.chatbot.Repository.BebidasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
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

    public List<BebidaDTO> getBebidas() {
        List<Bebidas> bebidas = bebidasRepository.findAll();
        List<BebidaDTO> dtos = new ArrayList<>();

        for (var bebida : bebidas) {
            dtos.add(new BebidaDTO(
                    bebida.getCodigoBebida(),
                    bebida.getBebida(),
                    bebida.getValorBebida(),
                    bebida.getImg() != null ? Base64.getMimeEncoder().encodeToString(bebida.getImg()) : null
            ));
        }

        return dtos;
    }

    public Bebidas findById(Long id) {
        return bebidasRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        bebidasRepository.deleteById(id);
    }
}
