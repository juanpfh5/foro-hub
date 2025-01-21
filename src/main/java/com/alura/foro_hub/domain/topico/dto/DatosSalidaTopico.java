package com.alura.foro_hub.domain.topico.dto;

import com.alura.foro_hub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosSalidaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String usuario,
        String curso
) {
    public DatosSalidaTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor().getNombre(),
                topico.getCurso().getNombre());

    }
}
