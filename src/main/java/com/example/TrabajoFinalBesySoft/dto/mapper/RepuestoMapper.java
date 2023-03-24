package com.example.TrabajoFinalBesySoft.dto.mapper;


import com.example.TrabajoFinalBesySoft.dto.Request.RepuestoInDto;
import com.example.TrabajoFinalBesySoft.dto.Request.VehiculoInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.RepuestoOutDto;
import com.example.TrabajoFinalBesySoft.dto.Response.VehiculoOutDto;
import com.example.TrabajoFinalBesySoft.model.Repuesto;
import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepuestoMapper {

    Repuesto mapToEntity(RepuestoInDto dto);

   RepuestoOutDto mapToDto(Repuesto entity);
}
