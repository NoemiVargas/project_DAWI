package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.dao.PaisRepository;
import com.proyecto.entity.Pais;

public class PaisServices {
	@Autowired
	private PaisRepository repo;
	
	public List<Pais>listarTodos(){
		return repo.findAll();
	}
	

}
