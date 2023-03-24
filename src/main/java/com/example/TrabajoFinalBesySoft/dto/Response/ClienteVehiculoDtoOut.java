package com.example.TrabajoFinalBesySoft.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ClienteVehiculoDtoOut {

        private String correoElectronico;
        private String apellido;
        private String nombres;
        private String patente;
    }


