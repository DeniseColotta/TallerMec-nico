package com.example.TrabajoFinalBesySoft.dto.Request;

import com.example.TrabajoFinalBesySoft.model.Cliente;

import java.util.List;

public class VehiculoInDto {
    private Long id;

    private Integer anio;

    private String marca;

    private String modelo;

    private String patente;

    private List<Cliente> clientes;
}
