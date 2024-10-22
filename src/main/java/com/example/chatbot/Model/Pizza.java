package com.example.chatbot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "pizza")
@Getter
@Setter
public class Pizza {

    @Id
    @Column(name = "codigopizza")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoPizza;

    @Column(name = "NOMEPIZZA", nullable = false)
    private String nomePizza;

    @Column(name = "INGREDIENTES")
    private String ingredientes;

    @Column(name = "DATACRIACAO")
    private Date dataCriacao;

    @Column(name= "VALORPIZZA")
    private Long valorPizza;
}
