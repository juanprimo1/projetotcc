package com.example.chatbot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedidos {

    @Id
    @Column(name = "CODIGOPEDIDO")
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

    public Pedidos() {
        this.codigoPedido = gerarId();
    }

    private Long gerarId() {
        return Long.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000)); // Gera um número entre 1000 e 9999
    }
}
