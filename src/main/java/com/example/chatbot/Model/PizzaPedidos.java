package com.example.chatbot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pizzapedidos")
@Getter
@Setter
public class PizzaPedidos {

    @Id
    @Column(name = "IDPIZZAPEDIDOS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPizzaPedido;

    @Column(name = "CODIGOPEDIDO")
    private Long codigoPedido;

    @Column(name = "CODIGOPIZZA")
    private Long codigopizza;

    @Column(name = "CODIGOBEBIDA")
    private Long codigoBebida;

    @Column(name = "SEQUENCIAPEDIDO")
    private Long sequenciaPedido;
}
