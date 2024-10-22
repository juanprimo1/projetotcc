package com.example.chatbot.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    @JsonProperty("nomeUsuario")
    private String nomeUsuario;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("telefone")
    private String telefone;
}
