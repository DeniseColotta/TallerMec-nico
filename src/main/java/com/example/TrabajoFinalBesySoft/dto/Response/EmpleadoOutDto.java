package com.example.TrabajoFinalBesySoft.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoOutDto {
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

    private String tipoDeEmpleado;
}
