package com.example.curso.demo.controller;

import java.util.List;

import com.example.curso.demo.entity.Curso;
import com.example.curso.demo.entity.Profesor;
import com.example.curso.demo.service.ICursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CursoRestController {

  @Autowired
  private ICursoService cursoService;

  @GetMapping("/cursos")
  public ResponseEntity<?> listaCursos(){
    List<Curso> listaCursos = cursoService.findAll();
    if(listaCursos != null && listaCursos.size() != 0){
        return new ResponseEntity<>(listaCursos,HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/crear_curso")
  public ResponseEntity<?> agregarCurso(@RequestBody Curso curso){
    cursoService.saveCurso(curso);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @PostMapping("/cursos_profesor")
  public ResponseEntity<?> verCursoProfesor(@RequestBody Profesor profesor){
    List<Curso> listaCursos = cursoService.getCursoProfesor(profesor.getId());
    if(listaCursos != null && listaCursos.size() != 0){
        return new ResponseEntity<>(listaCursos,HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
