package com.example.TrabajoFinalBesySoft.controller;

import com.example.TrabajoFinalBesySoft.dto.Request.ManoDeObraInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.ManoDeObraOutDto;
import com.example.TrabajoFinalBesySoft.service.implementation.ManoDeObraServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@Api(value="mano de obra Controlador", tags="Acciones para la entidad mano de obra")
@RequestMapping("/mano-obra")
public class ManoDeObraController {
    @Autowired
    private ManoDeObraServiceImpl manoDeObraService;

    @PostMapping
    public ResponseEntity<?> generarManoDeObra(@Valid @RequestBody ManoDeObraInDto manoDeObraDTO) {
        ManoDeObraOutDto nuevaManoDeObraDTO = manoDeObraService.generarManoDeObra(manoDeObraDTO);
        return ResponseEntity.ok(nuevaManoDeObraDTO);

    }
}