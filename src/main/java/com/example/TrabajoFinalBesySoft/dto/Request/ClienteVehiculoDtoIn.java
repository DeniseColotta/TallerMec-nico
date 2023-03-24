package com.example.TrabajoFinalBesySoft.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteVehiculoDtoIn {

        @NotBlank
        @Size(max = 80)
        private String apellido;
        @NotBlank
        private String correoElectronico;
        @NotBlank
        @Size(max = 100)
        private String nombres;
        @NotBlank
        private String patente;
    }


