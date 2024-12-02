package com.example.crud_thymeleaf.repository;

import com.example.crud_thymeleaf.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
