package com.alura.foro_hub.domain.usuario.dto;

import com.alura.foro_hub.domain.usuario.Usuario;

public record DatosListadoUsuario(
        String nombre,
        String correoElectronico
) {
    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getNombre(), usuario.getCorreoElectronico());
    }
}
