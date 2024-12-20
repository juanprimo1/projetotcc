package com.example.chatbot.Model.DTO;

import com.example.chatbot.Model.ItensPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PedidoDTO implements Serializable {

    private Long codigoPedido;
    private String informacaoAdicional;
    private BigDecimal valorPedido;
    private List<ItensPedido> itensPedido;
    private Long codigoUsuario;
}
