package com.example.TrabajoFinalBesySoft.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoOutDto {
    private Long id;

    private String marca;

    private String modelo;

    private String repuesto;

    private Double valor;
}
