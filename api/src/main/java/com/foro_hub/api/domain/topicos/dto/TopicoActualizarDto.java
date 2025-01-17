package com.foro_hub.api.domain.topicos.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoActualizarDto(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String status,
        String autor,
        String curso
) {
}
