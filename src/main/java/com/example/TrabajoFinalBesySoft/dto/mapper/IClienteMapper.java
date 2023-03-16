package com.example.TrabajoFinalBesySoft.dto.mapper;

import com.example.TrabajoFinalBesySoft.dto.Request.ClienteInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.ClienteOutDto;
import com.example.TrabajoFinalBesySoft.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    Cliente mapToEntity(ClienteInDto dto);

    ClienteOutDto mapToDto(Cliente entity);}