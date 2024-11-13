package com.example.chatbot.Model.DTO;

import com.example.chatbot.Model.Bebidas;

import java.util.Base64;
import java.util.Date;

public class BebidaConverter {

    public static Bebidas convertToBebida(BebidaDTO dto) {

        Bebidas newBebida = new Bebidas();

        newBebida.setBebida(dto.getBebida());
        newBebida.setValorBebida(dto.getValorBebida());
        newBebida.setDataCriacao(new Date());
        newBebida.setImg(Base64.getMimeDecoder().decode(dto.getImgBebida()));

        return newBebida;
    }
}
