package com.example.TrabajoFinalBesySoft.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class MecanicoOutDto {
    private Long id;

    private String apellido;

    private String nombres;

    private String celular;

    private String calle;

    private String codigoPostal;

    private String departamento;

    private String localidad;

    private String numero;

    private String piso;

    private Character activo;

    private String especialidad;
}
