package com.example.chatbot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGOUSUARIO")
    private Long codigoUsuario;

    @Column(name = "NOMEUSUARIO", nullable = false)
    private String nomeUsuario;

    @Column(name = "PIZZAFAV")
    private Long codigoPizzaFav;

    @Column(name = "DATAREGISTRO")
    private Date dataRegistro;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "ADM")
    private Long adm;

    @Column(name = "ACTIVE")
    private Long active;
}
