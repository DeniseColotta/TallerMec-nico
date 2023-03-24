package com.example.TrabajoFinalBesySoft.dto.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDto {
    private Long idOrdenTrabajo;
    private Long idEmpleado;
    private String formaPago;
    private String tipoTarjeta;
    private Integer cantidadCuotas;
}
