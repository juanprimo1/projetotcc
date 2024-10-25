package com.example.chatbot.Service;


import com.example.chatbot.Model.DTO.PedidoDTO;
import com.example.chatbot.Model.ItensPedido;
import com.example.chatbot.Model.Pedidos;
import com.example.chatbot.Model.PizzaPedidos;
import com.example.chatbot.Repository.PedidosRepository;
import com.example.chatbot.Repository.PizzaPedidosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidosService {

    private final PedidosRepository pedidosRepository;
    private final PizzaPedidosRepository pizzaPedidosRepository;
    private final PizzaService pizzaService;
    private final BebidasService bebidasService;

    public Pedidos create(PedidoDTO pedidos) {
        Integer seqPedido = 1;
        Pedidos pedFinal = new Pedidos();

        if (pedidos.getValorPedido() == null)
            throw new RuntimeException("Valor pedido não pode ser nulo!");

        for (ItensPedido item : pedidos.getItensPedido()) {
            PizzaPedidos pizzaPedidos = new PizzaPedidos();
            pizzaPedidos.setCodigoPedido(pedFinal.getCodigoPedido());
            pizzaPedidos.setSequenciaPedido(seqPedido.longValue());
            pizzaPedidos.setCodigopizza(item.getPizza().getCodigoPizza());
            pizzaPedidos.setCodigoBebida(item.getBebidas().getCodigoBebida());
            seqPedido++;
            pizzaPedidosRepository.save(pizzaPedidos);
        }

        pedFinal.setDataPedido(new Date());
        pedFinal.setInformacaoAdicional(pedidos.getInformacaoAdicional());
        pedFinal.setValorPedido(pedidos.getValorPedido());
        pedFinal.setCodigoUsuario(pedidos.getCodigoUsuario());

        return pedidosRepository.save(pedFinal);
    }

    public Pedidos repetirPedido(Long userId) {
        Pedidos ultimoPedido = pedidosRepository.getLastOrder(userId).orElseThrow(() -> new RuntimeException("Esse é o primeiro pedido deste usuário"));
        List<PizzaPedidos> itens =  pizzaPedidosRepository.getLastOrder(userId, ultimoPedido.getCodigoPedido());

        ultimoPedido.setItensPedido(new ArrayList<>());

        itens.stream().forEach((i) -> {
            ItensPedido item = new ItensPedido();
            item.setPizza(pizzaService.findById(i.getCodigopizza()));
            item.setBebidas(bebidasService.findById(i.getCodigoBebida()));

            ultimoPedido.getItensPedido().add(item);
        });

        return ultimoPedido;
    }
}
