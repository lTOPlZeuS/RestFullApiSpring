package com.example.curso.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "profesor_id")
  private Long profesorId;

  public Curso() {

  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Long getProfesorId() {
    return this.profesorId;
  }

  public void setProfesorId(Long profesorID) {
    this.profesorId = profesorID;
  }

  private static final long serialVersionUID=1L;
}
