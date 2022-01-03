package com.example.curso.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.curso.demo.dao.IProfesorDao;
import com.example.curso.demo.entity.Profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorServiceImp implements IProfesorService{

  @Autowired
  private IProfesorDao profesorDao;

  @Override
  @Transactional(readOnly = true)
  public List<Profesor> findAll() {
    return (List<Profesor>) profesorDao.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Profesor findProfesor(Profesor profesor) {
    return profesorDao.findByEmail(profesor.getEmail());
  }

  @Override
  @Transactional(readOnly = true)
  public Profesor checkProfesorLogin(Profesor profesor) {
    return profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
  }

  @Override
  @Transactional
  public void deleteProfesor(Profesor profesor) {
    profesorDao.deleteById(profesor.getId());
  }

  @Override
  @Transactional
  public Profesor updateProfesor(Profesor profesor) {
    return profesorDao.save(profesor);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Profesor> findProfesorById(Long id) {
    return profesorDao.findById(id);
  }

  @Override
  @Transactional
  public void deleteProfesor(Long id) {
    profesorDao.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Profesor findById(Long id) {
    return profesorDao.findById(id).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Profesor findByIdSQL(Long id) {
    return profesorDao.findByIdSQL(id);
  }

  @Override
  @Transactional
  public void save(Profesor profesor) {
    profesorDao.save(profesor);
  }

  @Override
  @Transactional
  public void deleteAllProfesores() {
    profesorDao.deleteAll();
  }
  
}
