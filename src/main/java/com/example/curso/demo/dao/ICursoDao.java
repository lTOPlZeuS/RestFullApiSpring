package com.example.curso.demo.dao;

import java.util.List;

import com.example.curso.demo.entity.Curso;

import org.springframework.data.repository.CrudRepository;

public interface ICursoDao extends CrudRepository<Curso,Long>{
  public List<Curso> findByProfesorId(Long id);
}
