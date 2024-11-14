package com.example.chatbot.Service;

import com.example.chatbot.Model.PizzaPedidos;
import com.example.chatbot.Repository.PizzaPedidosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaPedidosService {

    private final PizzaPedidosRepository pizzaPedidosRepository;
    public List<PizzaPedidos> getByPedido(Long pedidoId) {
        return pizzaPedidosRepository.findAllByCodigoPedido(pedidoId);
    }
}
