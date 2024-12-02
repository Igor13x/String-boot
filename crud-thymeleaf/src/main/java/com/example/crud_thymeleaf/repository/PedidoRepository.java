package com.example.crud_thymeleaf.repository;

import com.example.crud_thymeleaf.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
