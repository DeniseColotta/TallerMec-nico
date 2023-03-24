package com.example.TrabajoFinalBesySoft.dto.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
    public class FacturaDto{

        private Long idOrdenTrabajo;
        private Double importeTotal;

}
