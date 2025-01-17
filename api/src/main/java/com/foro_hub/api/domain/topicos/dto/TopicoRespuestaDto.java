package com.foro_hub.api.domain.topicos.dto;

import com.foro_hub.api.domain.topicos.Topicos;

import java.time.LocalDateTime;

public record TopicoRespuestaDto (
        Long id,
        String titulo,
        String Mensaje,
        LocalDateTime fechaCreacion,
        String curso,
        String status,
        String autor
){
    public TopicoRespuestaDto(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensaje(), topicos.getFechaCreacion(),
                topicos.getCurso(), topicos.getStatus().name(), topicos.getAutor());
    }


}
