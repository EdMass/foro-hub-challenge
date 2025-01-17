package com.foro_hub.api.domain.topicos.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoRegistroDto(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso){
}
