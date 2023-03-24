package com.example.TrabajoFinalBesySoft.dto.Request;

import com.example.TrabajoFinalBesySoft.model.OrdenDeTrabajo;
import com.example.TrabajoFinalBesySoft.model.Repuesto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenDeTrabajoInDto {

    private Long id;

    private OrdenDeTrabajo ordenTrabajo;

    private Repuesto repuesto;

    private Integer cantidad;

    private Double valorTotal;
}
