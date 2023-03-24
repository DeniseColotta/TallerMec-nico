package com.example.TrabajoFinalBesySoft.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ExceptionDto {
        private int estado;
        private String mensaje;
        private Map<String, String> detalle;
}
