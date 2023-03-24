package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.dto.Request.FacturaDto;
import com.example.TrabajoFinalBesySoft.dto.Request.OrdenTrabajoCreadaDto;
import com.example.TrabajoFinalBesySoft.dto.Request.PagoDto;
import com.example.TrabajoFinalBesySoft.dto.Request.ReparacionInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.OrdenDeTrabajoOutDto;




public interface IOrdenDeTrabajoService {
    OrdenTrabajoCreadaDto crear(OrdenTrabajoCreadaDto dto);
    OrdenDeTrabajoOutDto iniciarReparacion(Long id, ReparacionInDto reparacionInDto);
    FacturaDto generarFactura(Long idOrdenTrabajo);
    OrdenDeTrabajoOutDto registrarPago(PagoDto pagoDto);
    OrdenDeTrabajoOutDto entregarVehiculo(Long id);
}




