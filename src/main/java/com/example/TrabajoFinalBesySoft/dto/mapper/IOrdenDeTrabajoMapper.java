package com.example.TrabajoFinalBesySoft.dto.mapper;

import com.example.TrabajoFinalBesySoft.dto.Request.OrdenDeTrabajoInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.OrdenDeTrabajoOutDto;
import com.example.TrabajoFinalBesySoft.model.OrdenDeTrabajo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrdenDeTrabajoMapper {
    OrdenDeTrabajo mapToEntity(OrdenDeTrabajoInDto dto);

    OrdenDeTrabajoOutDto mapToDto(OrdenDeTrabajo entity);
}
