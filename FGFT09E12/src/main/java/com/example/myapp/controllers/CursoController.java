package com.example.myapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.model.Curso;
import com.example.myapp.service.CursoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService cursoService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCursos() {
        return ResponseEntity.ok(cursoService.getAllCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCursoById(Long id) {
        return ResponseEntity.ok(cursoService.getCursoById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCurso(@Valid @RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCurso(curso));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateCurso(@Valid @RequestBody Curso curso, Long id) {
        return ResponseEntity.ok(cursoService.updateCurso(id, curso));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }
}
