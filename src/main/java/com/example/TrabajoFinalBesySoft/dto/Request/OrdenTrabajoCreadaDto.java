package com.example.TrabajoFinalBesySoft.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenTrabajoCreadaDto {
        private Long id;
        private Integer cantidadCuotas;
        private String detalleFallas;
        private Long mecanico;
        private Long vehiculoId;
        private String nivelCombustible;
        private Long kilometraje;
    }

