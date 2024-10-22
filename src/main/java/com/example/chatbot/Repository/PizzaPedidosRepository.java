package com.example.chatbot.Repository;

import com.example.chatbot.Model.PizzaPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaPedidosRepository extends JpaRepository<PizzaPedidos, Long> {

    @Query(nativeQuery = true, value = "select PP.* " +
            "from PEDIDOS P," +
            "PIZZAPEDIDOS PP" +
            "where " +
            "P.usuario  = :usuario and " +
            "PP.codigopedido = P.codigopedido and " +
            "P.codigopedido = :codigoPedido and " +
            "row_number = 1" +
            "order by P.datapedido desc ")
    List<PizzaPedidos> getLastOrder(@Param("usuario") Long usuario, @Param("codigoPedido") Long codigoPedido);
}
