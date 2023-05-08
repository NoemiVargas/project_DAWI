package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.AlumnoRepository;
import com.proyecto.entity.Alumno;

@Service
public class AlumnoServices {
	
	@Autowired
	private AlumnoRepository repo;
	
	//métodos
	public void grabar(Alumno a) {
		repo.save(a);
	}
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	public Alumno buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Alumno> listarTodos(){
		return repo.findAll();
	}
	

}
