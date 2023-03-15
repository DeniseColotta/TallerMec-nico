package com.example.TrabajoFinalBesySoft.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String apellido;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column( length = 15)
    private String celular;

    @Column(name="telefono_linea", length = 15)
    private String telefonoDeLinea;

    @Email
    @Column(name="correo_electronico")
    private String correoElectronico;

    private String calle;

    @Column(name="codigo_postal")
    private String codigoPostal;

    private String departamento;

    private String localidad;

    private String numero;

    private String piso;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "clientes")
    private List<Vehiculo> vehiculos;
}
