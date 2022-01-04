package com.example.curso.demo.service;

import java.util.List;

import com.example.curso.demo.dao.ICursoDao;
import com.example.curso.demo.entity.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServiceImp implements ICursoService{

  @Autowired
  ICursoDao cursoDao;

  @Override

  @Transactional(readOnly=true)
  public List<Curso> findAll() {
    return (List<Curso>) cursoDao.findAll();
  }

  @Override
  public void saveCurso(Curso curso) {
    cursoDao.save(curso);
  }

  @Override
  public List<Curso> getCursoProfesor(Long id) {
    return (List<Curso>) cursoDao.findByProfesorId(id);
  }
  
}
