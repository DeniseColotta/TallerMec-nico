package com.example.TrabajoFinalBesySoft.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="detalle_ordenes_trabajo")
public class DetalleOrdenDeTrabajo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orden_trabajo_id")
    private OrdenDeTrabajo ordenTrabajo;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    private Repuesto repuesto;

    private Integer cantidad;

    private Float valorTotal;
}

