package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
