package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.usuario.Usuario;
import com.alura.foro_hub.domain.usuario.dto.DatosAutenticacionUsuario;
import com.alura.foro_hub.infra.security.DatosJWTToken;
import com.alura.foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        System.out.println("aaaaaaaaaaaaa");
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correoElectronico(),
                datosAutenticacionUsuario.contrasenia());
        System.out.println("1. " + authToken);
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        System.out.println("2. " + usuarioAutenticado);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        System.out.println("3. " + JWTtoken);
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

}
