package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.dto.Response.VehiculoOutDto;


public interface IVehiculoService {
    VehiculoOutDto buscarPorPatente(String patente);
}
