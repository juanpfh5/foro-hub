package com.alura.foro_hub.domain.curso.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank
        String nombre
) {
}
