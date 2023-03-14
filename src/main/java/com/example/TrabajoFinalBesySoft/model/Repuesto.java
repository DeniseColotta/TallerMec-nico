package com.example.TrabajoFinalBesySoft.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="repuestos")
public class Repuesto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private String repuesto;

    private Double valor;

    @OneToMany(mappedBy = "repuesto")
    private List<DetalleOrdenDeTrabajo>detalleOrdenTrabajos;
}
