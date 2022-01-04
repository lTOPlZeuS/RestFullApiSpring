package com.example.curso.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(length = 60, unique = true)
  private String email;

  @Column
  private String password;

  @Column(length = 100)
  private String foto;

  @Column(name="created_at")
  @Temporal(TemporalType.DATE)
  private Date createdAt;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="profesor_id",referencedColumnName = "id")
  private List<Curso> curso = new ArrayList<>();

  @ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "profesores_lenguajes",
		joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "lenguaje_id", referencedColumnName = "id"))
	private Set<Lenguaje> lenguajes = new HashSet<Lenguaje>();

  @PrePersist
  public void prePersist() {
    createdAt = new Date();
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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFoto() {
    return this.foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public List<Curso> getCurso() {
    return this.curso;
  }

  public void setCurso(List<Curso> curso) {
    this.curso = curso;
  }


  public Set<Lenguaje> getLenguajes() {
    return this.lenguajes;
  }

  public void setLenguajes(Set<Lenguaje> lenguajes) {
    this.lenguajes = lenguajes;
  }

  public void addLenguaje(Lenguaje lenguaje){
    this.lenguajes.add(lenguaje);
  }
  private static final long serialVersionUID = 1L;
}
