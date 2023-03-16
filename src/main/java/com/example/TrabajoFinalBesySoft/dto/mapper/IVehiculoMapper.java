package com.example.TrabajoFinalBesySoft.dto.mapper;

import com.example.TrabajoFinalBesySoft.dto.Request.VehiculoInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.VehiculoOutDto;
import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IVehiculoMapper {
    Vehiculo mapToEntity(VehiculoInDto dto);

    VehiculoOutDto mapToDto(Vehiculo entity);
}
