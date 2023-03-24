package com.example.TrabajoFinalBesySoft.dto.Request;

import com.example.TrabajoFinalBesySoft.model.Mecanico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManoDeObraInDto {
    private Long id;

    private Date duracionHs;

    private Mecanico mecanico;

    private String detalle;

    private OrdenDeTrabajoInDto ordenTrabajo;
}
