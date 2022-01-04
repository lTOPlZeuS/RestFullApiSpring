package com.example.curso.demo.service;

import java.util.List;

import com.example.curso.demo.entity.Lenguaje;

import org.springframework.stereotype.Service;

@Service
public interface ILenguajeService {
  public List<Lenguaje> findAll();

  public void saveLenguaje(Lenguaje lenguaje);

  public Lenguaje findLenguajeById(Long id);
}
