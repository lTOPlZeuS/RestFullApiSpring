package com.example.curso.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.curso.demo.entity.Profesor;
import com.example.curso.demo.service.IProfesorService;
import com.example.curso.mapper.Mapper;
import com.example.curso.model.MProfesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
  @Autowired
  IProfesorService profesorService;

  @GetMapping("/profesores")
  @ResponseStatus(value = HttpStatus.OK)
  public List<Profesor> findAll() {
    return profesorService.findAll();
  }

  @PostMapping("/find_profesor")
  public ResponseEntity<?> findProfesor(@RequestBody Profesor profesor) {
    Profesor profesorDb = profesorService.findProfesor(profesor);
    if(profesorDb != null){
      return new ResponseEntity<Profesor>(profesorDb, HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("login")
  public ResponseEntity<?> login(@RequestBody Profesor profesor){
    Profesor profesorDb = profesorService.checkProfesorLogin(profesor);
    if(profesorDb != null){
      List<Profesor> profesores = new ArrayList<>();
      profesores.add(profesorDb);
      List<MProfesor> mProfesor = new ArrayList<>();
      mProfesor = Mapper.convertirLista(profesores);
      return new ResponseEntity<>(mProfesor,HttpStatus.OK);
    }else{
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/sing_up")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {
    if(profesorService.findProfesor(profesor) == null) {
      profesorService.save(profesor);
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateProfesor(@PathVariable (value="id") Long id, @RequestBody Profesor profesor) {
    Profesor profesorDb = null;
    profesorDb = profesorService.findById(id);
    if(profesorDb != null){
      profesorDb.setNombre(profesor.getNombre());
      profesorDb.setEmail(profesor.getEmail());
      profesorService.updateProfesor(profesorDb);
      return new ResponseEntity<>(profesorDb,HttpStatus.CREATED);
    }else{
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
  }

  @PutMapping("/update_sql")
  public ResponseEntity<?> updateProfesorSql(@RequestBody Profesor profesor) {
    Profesor profesorDb = null;
    profesorDb = profesorService.findByIdSQL(profesor.getId());
    if(profesorDb != null){
      profesorDb.setNombre(profesor.getNombre());
      profesorDb.setEmail(profesor.getEmail());
      profesorService.updateProfesor(profesorDb);
      return new ResponseEntity<>(profesorDb,HttpStatus.CREATED);
    }else{
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
  }
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteProfesor(@PathVariable (value="id") Long id) {
    Profesor profesorDb = null;
    profesorDb = profesorService.findById(id);
    if(profesorDb != null){
      profesorService.deleteProfesor(profesorDb);
      return new ResponseEntity<Void>(HttpStatus.OK);
    }else{
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Void> deleteAllProfesores() {
    profesorService.deleteAllProfesores();
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @PostMapping("/delete_post")
  public ResponseEntity<Void> deleteProfesorPost(@RequestBody Profesor profesor) {
    if(profesorService.findProfesor(profesor) != null) {
      profesorService.deleteProfesor(profesor);
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }
}
