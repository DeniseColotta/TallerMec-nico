package com.example.TrabajoFinalBesySoft.service.implementation;

import com.example.TrabajoFinalBesySoft.Enum.EstadoEnum;
import com.example.TrabajoFinalBesySoft.dto.Request.FacturaDto;
import com.example.TrabajoFinalBesySoft.dto.Request.OrdenTrabajoCreadaDto;
import com.example.TrabajoFinalBesySoft.dto.Request.PagoDto;
import com.example.TrabajoFinalBesySoft.dto.Request.ReparacionInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.OrdenDeTrabajoOutDto;
import com.example.TrabajoFinalBesySoft.dto.mapper.IOrdenDeTrabajoMapper;
import com.example.TrabajoFinalBesySoft.dto.mapper.IOrdenTrabajoCrearMapper;
import com.example.TrabajoFinalBesySoft.dto.mapper.RepuestoMapper;
import com.example.TrabajoFinalBesySoft.exception.NotFoundException;
import com.example.TrabajoFinalBesySoft.model.*;
import com.example.TrabajoFinalBesySoft.repositories.IEmpleadoRepository;
import com.example.TrabajoFinalBesySoft.repositories.IMecanicoRepository;
import com.example.TrabajoFinalBesySoft.repositories.IOrdenTrabajoRepository;
import com.example.TrabajoFinalBesySoft.repositories.IVehiculoRepository;
import com.example.TrabajoFinalBesySoft.service.IOrdenDeTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenTrabajoServiceImpl implements IOrdenDeTrabajoService {

    @Autowired
    private IOrdenTrabajoRepository ordenDeTrabajoRepository;

    @Autowired
    private IMecanicoRepository mecanicoRepository;

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Autowired
    private IEmpleadoRepository empleadoRepo;

    @Autowired
    private IOrdenTrabajoCrearMapper mapper;

    @Autowired
    private IOrdenDeTrabajoMapper mapperOT;

    @Autowired
    private RepuestoMapper repuestoMapper;


    @Override
    public OrdenTrabajoCreadaDto crear(OrdenTrabajoCreadaDto ordenDeTrabajoDTO) {
        OrdenDeTrabajo ordenDeTrabajo = mapper.mapToEntity(ordenDeTrabajoDTO);
        ordenDeTrabajo.setFechaIngreso(new Date());
        ordenDeTrabajo.setEstado(String.valueOf(EstadoEnum.CREADA));

        Optional<Mecanico> mecanicoOptional = mecanicoRepository.findById(ordenDeTrabajoDTO.getMecanico());
        Mecanico mecanico = mecanicoOptional.get();
        List<ManoDeObra> manoDeObraList = ordenDeTrabajo.getManoDeObra();
        for (ManoDeObra manoDeObra : manoDeObraList) {
            manoDeObra.setMecanico(mecanico);
            manoDeObra.setOrdenDeTrabajo(ordenDeTrabajo);
        }

        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(ordenDeTrabajoDTO.getMecanico());
        Vehiculo vehiculo = vehiculoOptional.get();
        ordenDeTrabajo.setVehiculo(vehiculo);

        ordenDeTrabajoRepository.save(ordenDeTrabajo);
        return mapper.mapToDto(ordenDeTrabajo);
    }



    @Override
    public OrdenDeTrabajoOutDto iniciarReparacion(Long id, ReparacionInDto reparacionInDto) {
        Optional<OrdenDeTrabajo> ordenDeTrabajoOptional = ordenDeTrabajoRepository.findById(id);
        if (ordenDeTrabajoOptional.isPresent()) {
            OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoOptional.get();
            ordenDeTrabajo.setEstado(String.valueOf(EstadoEnum.EN_REPARACION));
            ordenDeTrabajo.setFechaFinReparacion(new Date());
            List<ManoDeObra> manoDeObraList = ordenDeTrabajo.getManoDeObra();
            for (ManoDeObra manoDeObra : manoDeObraList) {
                manoDeObra.setDuracionHs(reparacionInDto.getDuracionHs());
                manoDeObra.setDetalle(reparacionInDto.getDetalle());
            }
            DetalleOrdenDeTrabajo detalleOrdenDeTrabajo = new DetalleOrdenDeTrabajo();
            detalleOrdenDeTrabajo.setOrdenDeTrabajo(ordenDeTrabajo);

            Repuesto repuesto = repuestoMapper.mapToEntity(reparacionInDto.getRepuesto());
            detalleOrdenDeTrabajo.setRepuesto(repuesto);

            detalleOrdenDeTrabajo.setCantidad(reparacionInDto.getCantidad());
            detalleOrdenDeTrabajo.setValorTotal(reparacionInDto.getValorTotal());
            ordenDeTrabajo.getDetalleOrdenDeTrabajo().add(detalleOrdenDeTrabajo);
            ordenDeTrabajoRepository.save(ordenDeTrabajo);
            return mapperOT.mapToDto(ordenDeTrabajo);
        } else {
            throw new NotFoundException("No se encontró la orden de trabajo con id " + id);
        }
    }

@Override
        public FacturaDto generarFactura(Long idOrdenTrabajo) {
            OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoRepository.findById(idOrdenTrabajo).orElseThrow(() -> new NotFoundException("Orden de trabajo no encontrada con id " + idOrdenTrabajo));

            if (!ordenDeTrabajo.getEstado().equals(EstadoEnum.PARA_FACTURAR)) {
                throw new NotFoundException("La orden de trabajo no se encuentra en estado Para facturar");
            }

           Double importeTotal = calcularImporteTotal(ordenDeTrabajo);
            ordenDeTrabajo.setImporteTotal(ordenDeTrabajo.getImporteTotal());
            ordenDeTrabajo.setEstado(String.valueOf(EstadoEnum.FACTURADA));
            ordenDeTrabajoRepository.save(ordenDeTrabajo);

            return new FacturaDto(idOrdenTrabajo, importeTotal);
        }

        @Override
        public OrdenDeTrabajoOutDto registrarPago(PagoDto pagoDto) {
            OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoRepository.findById(pagoDto.getIdOrdenTrabajo()).orElseThrow(() -> new NotFoundException("Orden de trabajo no encontrada con id " + pagoDto.getIdOrdenTrabajo()));

            if (!ordenDeTrabajo.getEstado().equals(EstadoEnum.FACTURADA)) {
                throw new NotFoundException("La orden de trabajo no se encuentra en estado Facturada");
            }

            Empleado empleado = empleadoRepo.findById(pagoDto.getIdEmpleado()).orElseThrow(() -> new NotFoundException("Empleado no encontrado con id " + pagoDto.getIdEmpleado()));

            ordenDeTrabajo.setAdministrativo(empleado);
            ordenDeTrabajo.setFormaPago(pagoDto.getFormaPago());
            ordenDeTrabajo.setTipoTarjeta(pagoDto.getTipoTarjeta());
            ordenDeTrabajo.setCantidadCuotas(pagoDto.getCantidadCuotas());
            ordenDeTrabajo.setFechaPago(new Date());
            ordenDeTrabajoRepository.save(ordenDeTrabajo);
            return mapperOT.mapToDto(ordenDeTrabajo);
        }

    private Double calcularImporteTotal(OrdenDeTrabajo ordenDeTrabajo) {
        return ordenDeTrabajo.getDetalleOrdenDeTrabajo()
                .stream()
                .mapToDouble(detalle -> detalle.getValorTotal())
                .sum();
    }



    @Override
    public OrdenDeTrabajoOutDto entregarVehiculo(Long id) {


        Optional<OrdenDeTrabajo> optional = ordenDeTrabajoRepository.findById(id);

        if(optional.isEmpty()){
            throw new NotFoundException("No existe Orden de Trabajo con ese ID");
        }

        OrdenDeTrabajo ordenDeTrabajo = optional.get();

        if(!ordenDeTrabajo.getEstado().equals(EstadoEnum.FACTURADA.valor)){
            throw new NotFoundException("no corresponde el estado");
        }

        ordenDeTrabajo.setEstado(EstadoEnum.CERRADA.valor);

        return mapperOT.mapToDto(ordenDeTrabajo);

    }
    }









