package com.example.TrabajoFinalBesySoft.service.implementation;

import com.example.TrabajoFinalBesySoft.dto.Response.VehiculoOutDto;
import com.example.TrabajoFinalBesySoft.dto.mapper.IVehiculoMapper;
import com.example.TrabajoFinalBesySoft.exception.NotFoundException;

import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import com.example.TrabajoFinalBesySoft.repositories.IVehiculoRepository;
import com.example.TrabajoFinalBesySoft.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository repository;

    @Autowired
    private IVehiculoMapper mapper;

    @Override
    public VehiculoOutDto buscarPorPatente(String patente) {
        Vehiculo vehiculo = repository.findByPatente(patente);
        if (vehiculo==null) {
            throw new NotFoundException(String.format("El vehiculo patente %s no existe", patente), new RuntimeException("Causa Original"));
        }
        VehiculoOutDto vehiculos = mapper.mapToDto(vehiculo);
        return vehiculos;

    }

}


