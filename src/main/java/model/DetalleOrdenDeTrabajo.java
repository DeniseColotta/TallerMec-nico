package model;

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

    @OneToMany(mappedBy = "repuesto",cascade = CascadeType.ALL)
    @JoinColumn(name = "repuesto_id")
    private List<Repuesto> repuestos;

    private Integer cantidad;

    private Float valorTotal;
}

