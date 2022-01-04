package com.example.curso.demo.service;

import java.util.List;

import com.example.curso.demo.entity.Curso;

public interface ICursoService {

  public List<Curso> findAll();

  public void  saveCurso(Curso curso);

  public List<Curso> getCursoProfesor(Long id);
}
