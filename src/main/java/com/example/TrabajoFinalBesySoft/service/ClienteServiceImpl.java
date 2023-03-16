package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.dto.Request.ClienteInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.ClienteOutDto;
import com.example.TrabajoFinalBesySoft.dto.mapper.IClienteMapper;
import com.example.TrabajoFinalBesySoft.exception.ExistException;
import com.example.TrabajoFinalBesySoft.exception.NotFoundException;
import com.example.TrabajoFinalBesySoft.model.Cliente;
import com.example.TrabajoFinalBesySoft.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRepository repository;

    @Autowired
    private IClienteMapper mapper;

    @Override
    public ClienteOutDto obtenerPorEmail(String email) {
        Optional<Cliente> cliente = repository.findByCorreoElectronico(email);
        if (!cliente.isPresent()) {
            throw new NotFoundException(String.format("El cliente buscado, no existe"), new RuntimeException("Causa Original"));}
            ClienteOutDto clientes = mapper.mapToDto(cliente.get());
            return clientes;


    }

    @Override
    public ClienteOutDto crearCliente(ClienteInDto cliente) {
        Optional<Cliente> clienteIn = repository.findByCorreoElectronico(cliente.getCorreoElectronico());
        if (clienteIn.isPresent()) {
            throw new ExistException("El cliente que intenta ingresar ya existe");}
            Cliente clientes = repository.save(mapper.mapToEntity(cliente));
            return mapper.mapToDto(clientes);
        }

    @Override
    public Cliente actualizarCliente(Cliente cliente, Long id) {
        return null;
    }
}
