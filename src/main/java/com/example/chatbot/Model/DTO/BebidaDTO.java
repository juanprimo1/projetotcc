package com.example.chatbot.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BebidaDTO implements Serializable {

    private Long codigoBebida;
    private String bebida;
    private Long valorBebida;
    private String imgBebida;
}
