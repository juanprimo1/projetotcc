package com.example.chatbot.Model.DTO;

import com.example.chatbot.Model.Usuario;

public class UserConverter {

    public static Usuario convertToUser(UserDTO userDTO) {
        Usuario user = new Usuario();

        user.setNomeUsuario(userDTO.getNomeUsuario());
        user.setEmail(userDTO.getEmail());
        user.setSenha(userDTO.getSenha());
        user.setTelefone(user.getTelefone());

        return user;
    }
}
