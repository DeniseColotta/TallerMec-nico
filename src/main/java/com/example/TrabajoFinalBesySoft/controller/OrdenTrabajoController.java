package com.example.TrabajoFinalBesySoft.controller;


import com.example.TrabajoFinalBesySoft.dto.Request.FacturaDto;
import com.example.TrabajoFinalBesySoft.dto.Request.OrdenTrabajoCreadaDto;
import com.example.TrabajoFinalBesySoft.dto.Request.PagoDto;
import com.example.TrabajoFinalBesySoft.dto.Request.ReparacionInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.OrdenDeTrabajoOutDto;
import com.example.TrabajoFinalBesySoft.service.IOrdenDeTrabajoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@Api(value = "ordenes de trabajo Controlador", tags = "Acciones para la entidad orden de trabajo")
@RequestMapping("/ordenes-trabajo")
public class OrdenTrabajoController {

    @Autowired
    private IOrdenDeTrabajoService ordenDeTrabajoService;


    @PostMapping
    public ResponseEntity<?> generar(@Valid @RequestBody OrdenTrabajoCreadaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ordenDeTrabajoService.crear(dto));
    }

    @PutMapping("/reparacion/{id}")
    public ResponseEntity<OrdenDeTrabajoOutDto> iniciarReparacion(@PathVariable("id") Long id, @Valid @RequestBody ReparacionInDto reparacionInDto) {
        OrdenDeTrabajoOutDto ordenDeTrabajoOutDto = ordenDeTrabajoService.iniciarReparacion(id, reparacionInDto);
        return new ResponseEntity<>(ordenDeTrabajoOutDto, HttpStatus.OK);
    }


    @PostMapping("/facturar/{id}")
    public ResponseEntity<?> facturarOrdenDeTrabajo(@Valid @PathVariable Long id) {
        FacturaDto factura = ordenDeTrabajoService.generarFactura(id);
        return ResponseEntity.ok(factura);
    }


    @PostMapping("/cobrar/{id}")
    public ResponseEntity<?> cobrarOrdenDeTrabajo(@RequestBody PagoDto pagoDTO) {
        return ResponseEntity.ok(ordenDeTrabajoService.registrarPago(pagoDTO));
    }

    @PatchMapping("/entregar/{id}")
    public ResponseEntity<OrdenDeTrabajoOutDto> entregarVehiculo(@PathVariable Long id){
        return ResponseEntity.ok(this.ordenDeTrabajoService.entregarVehiculo(id));
    }
}


