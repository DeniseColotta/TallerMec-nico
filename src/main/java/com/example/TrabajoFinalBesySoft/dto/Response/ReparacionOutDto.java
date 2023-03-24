package com.example.TrabajoFinalBesySoft.dto.Response;


import com.example.TrabajoFinalBesySoft.dto.Request.RepuestoInDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReparacionOutDto {


        private Date duracionHs;
        private String detalle;
        private RepuestoInDto repuesto;
        private Integer cantidad;
        private Double valorTotal;

    }


