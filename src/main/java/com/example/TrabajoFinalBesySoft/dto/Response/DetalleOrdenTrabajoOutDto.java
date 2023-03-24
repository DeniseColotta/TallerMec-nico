package com.example.TrabajoFinalBesySoft.dto.Response;

import com.example.TrabajoFinalBesySoft.model.OrdenDeTrabajo;
import com.example.TrabajoFinalBesySoft.model.Repuesto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleOrdenTrabajoOutDto {
    private Long id;

    private OrdenDeTrabajo ordenTrabajo;

    private Repuesto repuesto;

    private Integer cantidad;

    private Double valorTotal;
}
