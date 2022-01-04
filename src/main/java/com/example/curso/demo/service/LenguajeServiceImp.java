package com.example.curso.demo.service;

import java.util.List;

import com.example.curso.demo.dao.ILenguajeDao;
import com.example.curso.demo.entity.Lenguaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LenguajeServiceImp implements ILenguajeService{

  @Autowired
  private ILenguajeDao lenguajeDao;

  @Override
  @Transactional(readOnly = true)
  public List<Lenguaje> findAll() {
    return (List<Lenguaje>) lenguajeDao.findAll();
  }

  @Override
  public void saveLenguaje(Lenguaje lenguaje) {
    lenguajeDao.save(lenguaje);
  }

  @Override
  public Lenguaje findLenguajeById(Long id) {
    return lenguajeDao.findByIdSQL(id);
  }
  
}
