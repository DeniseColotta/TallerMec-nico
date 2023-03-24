package com.example.TrabajoFinalBesySoft.repositories;

import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    Vehiculo findByPatente(String patente);
}
