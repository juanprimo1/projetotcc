package com.example.chatbot.Controller;

import com.example.chatbot.Model.Pedidos;
import com.example.chatbot.Service.PedidosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "pedidos")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PedidosController {

    private final PedidosService pedidosService;
    @PostMapping()
    public ResponseEntity<Object> postPedido(@RequestBody Pedidos pedido){
        return new ResponseEntity<>(pedidosService.create(pedido), HttpStatus.CREATED);
    }

    @PostMapping("ultimo-pedido/{userId}")
    public ResponseEntity<Object> lastOrder(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(pedidosService.repetirPedido(userId), HttpStatus.OK);
    }
}
