package com.example.TrabajoFinalBesySoft.dto.Request;

import com.example.TrabajoFinalBesySoft.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoInDto {
    private Long id;

    private Integer anio;

    private String marca;

    private String modelo;

    private String patente;

    private List<Cliente> clientes;
}
