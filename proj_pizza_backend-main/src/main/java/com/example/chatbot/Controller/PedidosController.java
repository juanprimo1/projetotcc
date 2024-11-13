package com.example.chatbot.Controller;

import com.example.chatbot.Model.DTO.PedidoDTO;
import com.example.chatbot.Model.Pedidos;
import com.example.chatbot.Service.PedidosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "pedidos")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PedidosController {

    private final PedidosService pedidosService;
    @PostMapping()
    public ResponseEntity<Object> postPedido(@RequestBody PedidoDTO pedido){
        return new ResponseEntity<>(pedidosService.create(pedido), HttpStatus.CREATED);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<PedidoDTO>> getAll() {
        return new ResponseEntity<>(pedidosService.getAll(), HttpStatus.OK);
    }

    @PostMapping("ultimo-pedido/{userId}")
    public ResponseEntity<Object> lastOrder(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(pedidosService.repetirPedido(userId), HttpStatus.OK);
    }

    @DeleteMapping("{idPedido}")
    public ResponseEntity<?> deletePedido(@PathVariable("idPedido") Long idPedido) {
        pedidosService.deleteById(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
