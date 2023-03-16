package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.dto.Response.VehiculoOutDto;
import com.example.TrabajoFinalBesySoft.model.Vehiculo;

import java.util.Optional;

public interface IVehiculoService {
    VehiculoOutDto buscarPorPatente(String patente);
}
