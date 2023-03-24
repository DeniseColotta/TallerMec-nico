package com.example.TrabajoFinalBesySoft.dto.Response;

import com.example.TrabajoFinalBesySoft.dto.Request.DetalleOrdenDeTrabajoInDto;
import com.example.TrabajoFinalBesySoft.dto.Request.ManoDeObraInDto;
import com.example.TrabajoFinalBesySoft.model.Empleado;
import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDeTrabajoOutDto {
    private Long id;

    private Integer cantidadCuotas;

    private String detalleFallas;

    private String estado;

    private Date fechaFinReparacion;

    private Date fechaIngreso;

    private Date fechaPago;

    private String formaPago;

    private Double importeTotal;

    private Long kilometraje;

    private String nivelCombustible;

    private  String tipoTarjeta;

    private Empleado recepcionista;

    private Empleado administrativo;

    private Vehiculo vehiculo;


    private List<ManoDeObraInDto> manoDeObra;

    private List<DetalleOrdenDeTrabajoInDto>detalleOrdenDeTrabajo;
}
