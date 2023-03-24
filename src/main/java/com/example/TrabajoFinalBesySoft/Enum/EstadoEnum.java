package com.example.TrabajoFinalBesySoft.Enum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EstadoEnum {

    CREADA("Creada"),
    EN_REPARACION("En reparación"),
    PARA_FACTURAR("Para facturar"),
    FACTURADA("Facturada"),
    CERRADA("Cerrada");

    public final String valor;

}