package com.example.curso.demo.controller;

import java.util.Collection;

import com.example.curso.demo.entity.Lenguaje;
import com.example.curso.demo.entity.Profesor;
import com.example.curso.demo.service.ILenguajeService;
import com.example.curso.demo.service.IProfesorService;
import com.example.curso.model.ProfesorLenguaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfesorLenguajeRestCotroller {
  @Autowired
  private ILenguajeService lenguajeService;

  @Autowired
  private IProfesorService profesorService;

  @PostMapping("lenguajes_profesor")
  public ResponseEntity<?> listaLenguajesProfesor(@RequestBody Profesor profesor){
    Profesor profesorDb = profesorService.findById(profesor.getId());
    if(profesorDb != null){
      Collection<Lenguaje> listaLenguaje = profesorDb.getLenguajes();
      if(profesorDb != null){
        return new ResponseEntity<>(listaLenguaje,HttpStatus.OK);
      }
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/save_lenguaje_profesor")
  public ResponseEntity<?> saveLenguajeProfesor(@RequestBody ProfesorLenguaje profesorLenguaje){
    Profesor profesorDb = profesorService.findById(profesorLenguaje.getProfesor().getId());
		if(profesorDb != null) {
			Lenguaje lenguajeDb = lenguajeService.findLenguajeById(profesorLenguaje.getLenguaje().getId());
			profesorDb.addLenguaje(lenguajeDb);
			profesorService.save(profesorDb);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
  }
}
