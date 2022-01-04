package com.example.curso.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.curso.demo.entity.Profesor;

import org.springframework.stereotype.Service;

@Service
public interface IProfesorService{

  public void save(Profesor profesor);

  public List<Profesor> findAll();

  public Profesor findProfesor(Profesor profesor);

  public Profesor checkProfesorLogin(Profesor profesor);

  public void deleteProfesor(Profesor profesor);

  public Profesor updateProfesor(Profesor profesor);

  public Optional<Profesor> findProfesorById(Long id);

  public void deleteProfesor(Long id);

  public Profesor findById(Long id);

  public Profesor findByIdSQL(Long id);

  public void deleteAllProfesores();
}
