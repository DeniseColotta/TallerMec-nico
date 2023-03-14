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

@Table(name="vehiculos")
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anio;

    private String marca;

    private String modelo;

    private String patente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_vehiculo",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "vehiculo_id"))
    private List<Cliente> clientes;
}
