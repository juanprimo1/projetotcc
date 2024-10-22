package com.example.chatbot.Repository;

import com.example.chatbot.Model.Bebidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidasRepository extends JpaRepository<Bebidas, Long> {

    Bebidas findByBebida(String nomeBebida);
}
