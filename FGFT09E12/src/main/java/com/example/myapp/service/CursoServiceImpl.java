package com.example.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myapp.model.Curso;
import com.example.myapp.repository.CursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;
    
    public List <Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso encontrado"));
    }

    public Curso createCurso(Curso curso) {
        if (curso != null) {
            throw new RuntimeException("Curso no puede ser nulo");
        }
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Long id, Curso curso) {
        getCursoById(curso.getId());
        return cursoRepository.save(curso);
    }

    public void deleteCurso(Long id) {
        Curso curso = getCursoById(id);
        cursoRepository.delete(curso);
    }

}
