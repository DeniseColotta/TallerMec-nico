package com.example.TrabajoFinalBesySoft.service.implementation;

import com.example.TrabajoFinalBesySoft.dto.Request.ManoDeObraInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.ManoDeObraOutDto;
import com.example.TrabajoFinalBesySoft.model.ManoDeObra;
import com.example.TrabajoFinalBesySoft.model.Mecanico;
import com.example.TrabajoFinalBesySoft.model.OrdenDeTrabajo;
import com.example.TrabajoFinalBesySoft.repositories.IManoObraRepository;
import com.example.TrabajoFinalBesySoft.repositories.IMecanicoRepository;
import com.example.TrabajoFinalBesySoft.repositories.IOrdenTrabajoRepository;
import com.example.TrabajoFinalBesySoft.service.IManoDeObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManoDeObraServiceImpl implements IManoDeObraService {

        @Autowired
        private IManoObraRepository manoDeObraRepository;

        @Autowired
        private IOrdenTrabajoRepository ordenDeTrabajoRepository;

        @Autowired
        private IMecanicoRepository mecanicoRepository;

        public ManoDeObraOutDto generarManoDeObra(ManoDeObraInDto manoDeObraDTO) {
            Optional<OrdenDeTrabajo> ordenDeTrabajo = ordenDeTrabajoRepository.findById(manoDeObraDTO.getOrdenTrabajo().getId());
            Optional<Mecanico> mecanico = mecanicoRepository.findById(manoDeObraDTO.getMecanico().getId());

            ManoDeObra manoDeObra = new ManoDeObra();
            manoDeObra.setDuracionHs(manoDeObraDTO.getDuracionHs());
            manoDeObra.setDetalle(manoDeObraDTO.getDetalle());
            manoDeObra.setMecanico(mecanico.get());
            manoDeObra.setOrdenDeTrabajo(ordenDeTrabajo.get());

            manoDeObra = manoDeObraRepository.save(manoDeObra);

            ordenDeTrabajo.get().getManoDeObra().add(manoDeObra);
            ordenDeTrabajoRepository.save(ordenDeTrabajo.get());

            return new ManoDeObraOutDto(manoDeObra.getId(), manoDeObra.getDuracionHs(), manoDeObra.getMecanico(), manoDeObra.getDetalle(), manoDeObra.getOrdenDeTrabajo());
        }
    }


