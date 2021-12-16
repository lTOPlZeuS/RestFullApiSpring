package com.example.curso.demo.controller;

import java.util.List;

import com.example.curso.demo.entity.Profesor;
import com.example.curso.demo.service.IProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
