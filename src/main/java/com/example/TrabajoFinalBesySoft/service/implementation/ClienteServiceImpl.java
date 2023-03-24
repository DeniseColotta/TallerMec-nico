package com.example.TrabajoFinalBesySoft.service.implementation;

import com.example.TrabajoFinalBesySoft.dto.Request.ClienteVehiculoDtoIn;
import com.example.TrabajoFinalBesySoft.dto.mapper.IClienteMapper;
import com.example.TrabajoFinalBesySoft.dto.mapper.IClienteVehiculoMapper;
import com.example.TrabajoFinalBesySoft.dto.mapper.IVehiculoMapper;
import com.example.TrabajoFinalBesySoft.exception.NotFoundException;
import com.example.TrabajoFinalBesySoft.model.Cliente;
import com.example.TrabajoFinalBesySoft.model.Vehiculo;
import com.example.TrabajoFinalBesySoft.repositories.IClienteRepository;
import com.example.TrabajoFinalBesySoft.repositories.IVehiculoRepository;
import com.example.TrabajoFinalBesySoft.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository repoCliente;

    @Autowired
    private IVehiculoRepository repoVehiculo;

    @Autowired
    private IClienteMapper mapper;

    @Autowired
    private IVehiculoMapper mapperVehiculo;

    @Autowired
    private IClienteVehiculoMapper mapperVC;



    @Override
    public void registrarClienteVehiculo(ClienteVehiculoDtoIn clienteVehiculoDtoIn) {

        Vehiculo vehiculo = repoVehiculo.findByPatente(clienteVehiculoDtoIn.getPatente());
        Cliente cliente;

        if (vehiculo != null) {
            cliente = vehiculo.getClientes().stream()
                    .filter(c -> c.getCorreoElectronico().equals(clienteVehiculoDtoIn.getCorreoElectronico()))
                    .findFirst().orElse(null);
            if (cliente == null) {
                throw new NotFoundException(String.format("No existe cliente con el correo electrónico indicado para el vehículo con la patente %s", clienteVehiculoDtoIn.getPatente()), new RuntimeException("Causa Original"));
            }
        } else {
            cliente = repoCliente.findByCorreoElectronico(clienteVehiculoDtoIn.getCorreoElectronico());
            if (cliente == null) {
                cliente = mapperVC.mapToCliente(clienteVehiculoDtoIn);
                cliente = repoCliente.save(cliente);
            }
            vehiculo = mapperVC.mapToVehiculo(clienteVehiculoDtoIn);
            vehiculo.setClientes(new ArrayList<>());
            vehiculo.getClientes().add(cliente);
            repoVehiculo.save(vehiculo);

            if (!cliente.getVehiculos().contains(vehiculo)) {
                cliente.getVehiculos().add(vehiculo);
                repoCliente.save(cliente);
            }
        }


    }}

