package com.example.chatbot.Service;

import com.example.chatbot.Model.DTO.UserConverter;
import com.example.chatbot.Model.DTO.UserDTO;
import com.example.chatbot.Model.Usuario;
import com.example.chatbot.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario registerUser(UserDTO usuario) {
        Usuario user = UserConverter.convertToUser(usuario);
        Usuario userExists = findUser(usuario.getEmail());

        if (userExists != null)
            throw  new RuntimeException("Usuário já existente, faça login");

        if (user.getSenha().length() < 6)
            throw new RuntimeException("Senha curta demais!");

        user.setSenha(Base64.getEncoder().encodeToString(usuario.getSenha().getBytes()));
        user.setDataRegistro(new Date());
        user.setAdm(0L);
        user.setActive(1L);
        return usuarioRepository.save(user);
    }

    public Usuario loginUser(String email, String senha) {

        String senhaCrypto = Base64.getEncoder().encodeToString(senha.getBytes());

        Usuario user = usuarioRepository.findByEmailAndSenha(email, senhaCrypto).orElseThrow(() -> new RuntimeException("Usuario não encontrado, verifique suas credenciais!"));

        user.setActive(1L);

        return user;
    }

    public Usuario findUser(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }
}
