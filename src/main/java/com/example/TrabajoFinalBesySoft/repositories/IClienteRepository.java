package com.example.TrabajoFinalBesySoft.repositories;

import com.example.TrabajoFinalBesySoft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {
}
