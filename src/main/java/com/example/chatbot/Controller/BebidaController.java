package com.example.chatbot.Controller;

import com.example.chatbot.Model.Bebidas;
import com.example.chatbot.Service.BebidasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bebidas")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class BebidaController {

    private final BebidasService bebidasService;

    @PostMapping
    public ResponseEntity<Bebidas> create(@RequestBody Bebidas bebida) {
        return new ResponseEntity<>(bebidasService.create(bebida), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bebidas>> getPizzas() {
        return new ResponseEntity<>(bebidasService.getBebidas(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<Bebidas> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bebidasService.findById(id), HttpStatus.OK);
    }
}
