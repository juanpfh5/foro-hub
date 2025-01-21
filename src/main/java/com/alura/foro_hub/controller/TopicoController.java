package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.topico.Topico;
import com.alura.foro_hub.domain.topico.TopicoRepository;
import com.alura.foro_hub.domain.topico.dto.DatosActualizarTopico;
import com.alura.foro_hub.domain.topico.dto.DatosSalidaTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        return ResponseEntity.ok(topicoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<DatosSalidaTopico> crearTopico(@RequestBody @Valid Topico topico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topicoNuevo = topicoRepository.save(topico);
        return ResponseEntity.created(uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoNuevo.getId()).toUri()).body(new DatosSalidaTopico(topicoNuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosSalidaTopico> actualizarTopico(@PathVariable Long id,
                                                              @RequestBody @Valid DatosActualizarTopico topico) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        topicoExistente.get().setTitulo(topico.titulo());
        topicoExistente.get().setMensaje(topico.mensaje());
        topicoRepository.save(topicoExistente.get());
        return ResponseEntity.ok(new DatosSalidaTopico(topicoExistente.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        topicoRepository.delete(topicoExistente.get());
        return ResponseEntity.noContent().build();
    }
}
