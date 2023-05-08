package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
