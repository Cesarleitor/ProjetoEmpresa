package com.cesar.pedidos.repository;


import com.cesar.pedidos.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}

