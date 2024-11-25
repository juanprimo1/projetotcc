package com.example.chatbot.Repository;

import com.example.chatbot.Model.PizzaPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PizzaPedidosRepository extends JpaRepository<PizzaPedidos, Long> {

    @Query(nativeQuery = true, value = "select PP.* \n" +
            "            from PEDIDOS P,\n" +
            "            PIZZAPEDIDOS PP\n" +
            "            where \n" +
            "            P.usuario  = :usuario and \n" +
            "            PP.codigopedido = P.codigopedido and \n" +
            "            P.codigopedido = :codigoPedido \n" +
            "            order by P.datapedido desc \n" +
            "            limit 1")
    List<PizzaPedidos> getLastOrder(@Param("usuario") Long usuario, @Param("codigoPedido") Long codigoPedido);

    List<PizzaPedidos> findAllByCodigoPedido(Long codigoPedido);

    List<PizzaPedidos> findAllByCodigopizza(Long codigoPizza);
    List<PizzaPedidos> findAllByCodigoBebida(Long codigoBebida);
}
