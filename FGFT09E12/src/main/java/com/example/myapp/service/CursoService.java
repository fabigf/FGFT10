package com.example.myapp.service;

import com.example.myapp.model.Curso;
import java.util.List;

public interface CursoService {
    List<Curso> getAllCursos();
    Curso getCursoById(Long id);
    Curso createCurso(Curso curso);
    Curso updateCurso(Long id, Curso curso);
    void deleteCurso(Long id);
}
