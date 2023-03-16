package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.dto.Response.VehiculoOutDto;
import com.example.TrabajoFinalBesySoft.dto.mapper.IVehiculoMapper;
import com.example.TrabajoFinalBesySoft.exception.NotFoundException;

import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import com.example.TrabajoFinalBesySoft.repositories.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository repository;

    @Autowired
    private IVehiculoMapper mapper;

    @Override
    public VehiculoOutDto buscarPorPatente(String patente) {
        Optional<Vehiculo> vehiculo = repository.findByPatente(patente);
        if (!vehiculo.isPresent()) {
            throw new NotFoundException(String.format("El vehiculo patente %s no existe", patente), new RuntimeException("Causa Original"));
        }
        VehiculoOutDto vehiculos = mapper.mapToDto(vehiculo.get());
        return vehiculos;

    }

}


