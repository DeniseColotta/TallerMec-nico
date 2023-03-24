package com.example.TrabajoFinalBesySoft.dto.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReparacionInDto {

    private Date duracionHs;
    private String detalle;
    private RepuestoInDto repuesto;
    private Integer cantidad;
    private Double valorTotal;

}

