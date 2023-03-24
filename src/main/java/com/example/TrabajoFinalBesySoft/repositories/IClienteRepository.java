package com.example.TrabajoFinalBesySoft.repositories;

import com.example.TrabajoFinalBesySoft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findByCorreoElectronico(String email);
    Cliente findByApellidoAndNombres(String apellido, String nombres);

}
