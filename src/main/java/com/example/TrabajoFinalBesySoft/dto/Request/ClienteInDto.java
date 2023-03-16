package com.example.TrabajoFinalBesySoft.dto.Request;

import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInDto {

    private Long id;

   @Size(max=80)
   @NotBlank
    private String apellido;

    @Size(max=100)
    @NotBlank
    private String nombres;

    @Size(max=15)
    private String celular;

    @Size(max=15)
    private String telefonoDeLinea;

    @Email
    private String correoElectronico;

    private String calle;

    private String codigoPostal;

    private String departamento;

    private String localidad;

    private String numero;

    private String piso;

    private List<Vehiculo> vehiculos;
}
