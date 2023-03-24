package com.example.TrabajoFinalBesySoft.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="mano_obra")
public class ManoDeObra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "duracion_hs")
    @Temporal(TemporalType.TIME)
    private Date duracionHs;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;

    private String detalle;

    @ManyToOne
    @JoinColumn(name = "orden_trabajo_id")
    private OrdenDeTrabajo ordenDeTrabajo;
}
