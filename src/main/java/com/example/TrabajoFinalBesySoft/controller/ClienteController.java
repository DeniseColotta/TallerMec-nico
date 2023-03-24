package com.example.TrabajoFinalBesySoft.controller;

import com.example.TrabajoFinalBesySoft.dto.Request.ClienteVehiculoDtoIn;

import com.example.TrabajoFinalBesySoft.service.IClienteService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@Api(value="Cliente Controlador", tags="Acciones para la entidad Cliente")
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @PostMapping
    public ResponseEntity<?> registrarClienteVehiculo(@Valid @RequestBody ClienteVehiculoDtoIn clienteVehiculoDtoIn) {
        service.registrarClienteVehiculo(clienteVehiculoDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}


