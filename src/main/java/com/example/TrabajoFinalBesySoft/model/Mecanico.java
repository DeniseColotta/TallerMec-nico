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

@Table(name="mecanicos")
public class Mecanico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String nombres;

    @Column( length = 15)
    private String celular;

    private String calle;

    @Column(name="codigo_postal")
    private String codigoPostal;

    private String departamento;

    private String localidad;

    private String numero;

    private String piso;

    private Character activo;

    private String especialidad;


}
