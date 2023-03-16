package com.example.TrabajoFinalBesySoft.repositories;

import com.example.TrabajoFinalBesySoft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByCorreoElectronico(String email);
}
