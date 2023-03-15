package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.exception.NotFoundException;

import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import com.example.TrabajoFinalBesySoft.repositories.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository repository;

    @Override
    public Optional<Vehiculo> buscarPorPatente(String patente){
        Optional<Vehiculo>vehiculo=repository.findByPatente(patente);
        if(vehiculo.isPresent()){
            return vehiculo;
        }else {
            throw  new NotFoundException(String.format("El vehiculo patente %s no existe",patente), new RuntimeException("Causa Original"));}}
        }



