package com.example.TrabajoFinalBesySoft.Enum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
    public enum FormaDePagoEnum {

        EFECTIVO("Efectivo"),
        DEBITO("Débito"),
        CREDITO("Crédito"),
        MERCADO_PAGO ("Mercado Pago");

        public final String valor;

    }

