package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.usuario.Usuario;
import com.alura.foro_hub.domain.usuario.UsuarioRepository;
import com.alura.foro_hub.domain.usuario.dto.DatosListadoUsuario;
import com.alura.foro_hub.domain.usuario.dto.DatosRegistroUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<DatosListadoUsuario>> mostrarUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll().stream().map(DatosListadoUsuario::new).toList());
    }

    @PostMapping
    public ResponseEntity<DatosListadoUsuario> crearUsuario(@RequestBody @Valid DatosRegistroUsuario datosListadoUsuario, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRepository.save(new Usuario(datosListadoUsuario));
        return ResponseEntity.created(uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri()).body(new DatosListadoUsuario(usuario));
    }
}
