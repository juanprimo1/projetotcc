package com.example.chatbot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPedido;

    @Column(name = "VALORPEDIDO", nullable = false)
    private Long valorPedido;

    @Column(name = "DATAPEDIDO")
    private Date dataPedido;

    @Column(name = "INFORMACAOADICIONAL")
    private String informacaoAdicional;

    @Column(name = "USUARIO")
    private Long codigoUsuario;

    private transient List<ItensPedido> itensPedido;
}
