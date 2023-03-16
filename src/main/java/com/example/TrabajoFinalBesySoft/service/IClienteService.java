package com.example.TrabajoFinalBesySoft.service;


import com.example.TrabajoFinalBesySoft.dto.Request.ClienteInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.ClienteOutDto;
import com.example.TrabajoFinalBesySoft.model.Cliente;

import java.util.Optional;

public interface IClienteService {
   ClienteOutDto obtenerPorEmail(String email);

    ClienteOutDto crearCliente(ClienteInDto cliente);

    Cliente actualizarCliente(Cliente cliente, Long id);
}
