package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.model.Vehiculo;

import java.util.Optional;

public interface IVehiculoService {
    Optional<Vehiculo> buscarPorPatente(String patente);
}
