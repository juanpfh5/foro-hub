package com.alura.foro_hub.domain.topico.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Future
        LocalDateTime fecha,
        @NotNull
        Long id_usuario,
        @NotNull
        Long id_curso
) {
}
