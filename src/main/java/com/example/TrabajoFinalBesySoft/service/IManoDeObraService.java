package com.example.TrabajoFinalBesySoft.service;

import com.example.TrabajoFinalBesySoft.dto.Request.ManoDeObraInDto;
import com.example.TrabajoFinalBesySoft.dto.Response.ManoDeObraOutDto;

public interface IManoDeObraService {
    ManoDeObraOutDto generarManoDeObra(ManoDeObraInDto manoDeObraDTO);
}
