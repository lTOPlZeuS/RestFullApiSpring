package com.example.curso.mapper;

import java.util.List;
import java.util.ArrayList;

import com.example.curso.demo.entity.Profesor;
import com.example.curso.model.MProfesor;

import org.springframework.stereotype.Component;

@Component("mapper")
public class Mapper {
  public static List<MProfesor> convertirLista(List<Profesor> profesores){
    List<MProfesor> mProfesores = new ArrayList<>();
    for(Profesor profesor : profesores){
      mProfesores.add(new MProfesor(profesor));
    }
    return mProfesores;
  }
}
