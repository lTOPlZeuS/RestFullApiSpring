package com.example.curso.model;

import com.example.curso.demo.entity.Lenguaje;
import com.example.curso.demo.entity.Profesor;

public class ProfesorLenguaje {
  private Profesor profesor;
  private Lenguaje lenguaje;

  public Profesor getProfesor() {
    return this.profesor;
  }

  public void setProfesor(Profesor profesor) {
    this.profesor = profesor;
  }

  public Lenguaje getLenguaje() {
    return this.lenguaje;
  }

  public void setLenguaje(Lenguaje lenguaje) {
    this.lenguaje = lenguaje;
  }
  
}
