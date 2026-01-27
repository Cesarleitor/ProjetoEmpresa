package com.cesar.pedidos.repository;

import com.cesar.pedidos.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {}
