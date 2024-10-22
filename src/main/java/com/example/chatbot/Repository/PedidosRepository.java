package com.example.chatbot.Repository;

import com.example.chatbot.Model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

    @Query(nativeQuery = true, value = " SELECT *" +
            "  FROM PEDIDOS P" +
            "  WHERE " +
            "  P.USUARIO  = :usuario" +
            "  ORDER BY P.DATAPEDIDO DESC " +
            "  LIMIT 1")
    Optional<Pedidos> getLastOrder(@Param("usuario") Long usuario);

}
