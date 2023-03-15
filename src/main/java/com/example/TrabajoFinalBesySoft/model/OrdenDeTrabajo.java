package com.example.TrabajoFinalBesySoft.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="ordenes_trabajo")
public class OrdenDeTrabajo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cantidad_cuotas")
    private Integer cantidadCuotas;

    @Column(name="detalle_fallas")
    private String detalleFallas;

    private String estado;

    @Column(name="fecha_fin_reparacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinReparacion;

    @Column(name="fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(name="fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;

    @Column(name="forma_pago")
    private String formaPago;

    @Column(name="importe_total")
    private Double importeTotal;

    private Long kilometraje;

    @Column(name="nivel_combustible")
    private String nivelCombustible;

    @Column(name="tipo_tarjeta")
    private  String tipoTarjeta;


    @ManyToOne
    @JoinColumn(name="recepcionista_id")
    private Empleado recepcionista;

    @ManyToOne
    @JoinColumn(name="administrativo_id")
    private Empleado administrativo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
}
