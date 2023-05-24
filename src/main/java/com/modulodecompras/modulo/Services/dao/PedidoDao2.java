package com.modulodecompras.modulo.Services.dao;

import com.modulodecompras.modulo.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoDao2 extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.id = (SELECT MAX(p2.id) FROM Pedido p2)")
    Optional<Pedido> findMaiorValorID();
}
