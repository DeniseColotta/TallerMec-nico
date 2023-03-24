package com.example.TrabajoFinalBesySoft.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoInDto {
    private Long id;

    @NotBlank
    private String apellido;

    @NotBlank
    private String nombres;

   @Size(max=15)
    private String celular;

    private String calle;

    private String codigoPostal;

    private String departamento;

    private String localidad;

    private String numero;

    private String piso;

    private String tipoDeEmpleado;
}
