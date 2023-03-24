package com.example.TrabajoFinalBesySoft.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoInDto {
    private Long id;

    private String marca;

    private String modelo;

    private String repuesto;

    private Double valor;
}
