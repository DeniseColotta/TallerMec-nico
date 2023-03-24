package com.example.TrabajoFinalBesySoft.dto.mapper;

import com.example.TrabajoFinalBesySoft.dto.Request.ClienteVehiculoDtoIn;
import com.example.TrabajoFinalBesySoft.dto.Response.ClienteVehiculoDtoOut;
import com.example.TrabajoFinalBesySoft.model.Cliente;
import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClienteVehiculoMapper {

    Cliente mapToCliente(ClienteVehiculoDtoIn dto);

    ClienteVehiculoDtoOut mapToDtoCliente(Cliente entity);

Vehiculo mapToVehiculo(ClienteVehiculoDtoIn dto);
ClienteVehiculoDtoOut mapToDtoVehiculo(Vehiculo entity);

}
