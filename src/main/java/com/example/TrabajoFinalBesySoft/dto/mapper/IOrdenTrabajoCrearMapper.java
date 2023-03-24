package com.example.TrabajoFinalBesySoft.dto.mapper;

import com.example.TrabajoFinalBesySoft.dto.Request.OrdenTrabajoCreadaDto;
import com.example.TrabajoFinalBesySoft.model.OrdenDeTrabajo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrdenTrabajoCrearMapper {
    OrdenDeTrabajo mapToEntity(OrdenTrabajoCreadaDto dto);

    OrdenTrabajoCreadaDto mapToDto(OrdenDeTrabajo entity);
}
