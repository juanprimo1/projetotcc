package com.example.chatbot.Model.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PizzaDTO implements Serializable {
    private Long codigoPizza;
    private String nomePizza;
    private String ingredientes;
    private Date dataCriacao;
    private Long valorPizza;
    private String imagem;
}
