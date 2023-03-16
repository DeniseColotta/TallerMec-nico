package com.example.TrabajoFinalBesySoft.dto.Response;

import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteOutDto {
    private Long id;

    private String apellido;

    private String nombres;

    private String celular;

    private String telefonoDeLinea;

    private String correoElectronico;

    private String calle;

    private String codigoPostal;

    private String departamento;

    private String localidad;

    private String numero;

    private String piso;

    private List<Vehiculo> vehiculos;
}



