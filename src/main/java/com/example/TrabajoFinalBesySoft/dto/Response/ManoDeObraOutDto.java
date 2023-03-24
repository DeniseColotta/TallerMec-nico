package com.example.TrabajoFinalBesySoft.dto.Response;

import com.example.TrabajoFinalBesySoft.model.Mecanico;
import com.example.TrabajoFinalBesySoft.model.OrdenDeTrabajo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManoDeObraOutDto {
    private Long id;

    private Date duracionHs;

    private Mecanico mecanico;

    private String detalle;

    private OrdenDeTrabajo ordenTrabajo;
}
