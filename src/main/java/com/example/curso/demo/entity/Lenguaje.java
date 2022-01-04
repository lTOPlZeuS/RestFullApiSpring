package com.example.curso.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="lenguaje")
public class Lenguaje implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;

  @Column(name="date")
  @Temporal(TemporalType.DATE)
  private Date date;

  @ManyToMany
	@JoinTable(name = "profesores_lenguajes", 
		joinColumns = @JoinColumn(name = "lenguaje_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"))
	private Set<Profesor> profesores = new HashSet<Profesor>();

  @PrePersist
  public void prePersist() {
    date = new Date();
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

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Set<Profesor> getProfesores() {
    return this.profesores;
  }

  public void setProfesores(Set<Profesor> profesores) {
    this.profesores = profesores;
  }

  private static final long serialVersionUID=1L;
}
