package com.example.chatbot.Controller;

import com.example.chatbot.Model.DTO.UserDTO;
import com.example.chatbot.Model.Usuario;
import com.example.chatbot.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("register")
    public ResponseEntity<Usuario> registerUsuario(@RequestBody UserDTO user) {
        return new ResponseEntity<>(usuarioService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("login/{email}/{senha}")
    public ResponseEntity<Usuario> loginUser(@PathVariable("email") String email, @PathVariable("senha")String senha) {
        return new ResponseEntity<>(usuarioService.loginUser(email, senha), HttpStatus.OK);
    }

    @GetMapping("find/{email}")
    public ResponseEntity<Usuario> getUser(String email){
        return new ResponseEntity<>(usuarioService.findUser(email), HttpStatus.OK);
    }
}
