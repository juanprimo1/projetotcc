package com.example.chatbot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "bebidas")
@Getter
@Setter
public class Bebidas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoBebida;

    @Column(name = "BEBIDA", nullable = false)
    private String bebida;

    @Column(name = "VALORBEBIDA", nullable = false)
    private Long valorBebida;

    @Column(name = "DATACRIACAO")
    private Date dataCriacao;
}
