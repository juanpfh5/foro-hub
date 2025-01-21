package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.curso.Curso;
import com.alura.foro_hub.domain.curso.CursoRepository;
import com.alura.foro_hub.domain.curso.dto.DatosCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> mostrarCursos() {
        return ResponseEntity.ok(cursoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<DatosCurso> crearCurso(@RequestBody @Valid DatosCurso curso, UriComponentsBuilder uriComponentsBuilder) {
        Curso cursoNuevo = cursoRepository.save(new Curso(curso));
        return ResponseEntity.created(uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(cursoNuevo.getId()).toUri()).body(new DatosCurso(cursoNuevo.getNombre()));
    }
}
