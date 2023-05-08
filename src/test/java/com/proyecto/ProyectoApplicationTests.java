package com.proyecto;

import static org.mockito.ArgumentMatchers.anyBoolean;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.entity.Alumno;
import com.proyecto.services.AlumnoServices;

@SpringBootTest
class ProyectoApplicationTests {
	@Autowired
	private AlumnoServices servicio;
	

	@Test
	void contextLoads() {
		List<Alumno> data= servicio.listarTodos();
		for(Alumno a: data)
			System.out.println(a.getCodAlu()+"------------"+a.getNomAlu()+"----------"+
		a.getApelliAlu()+"--------"+a.getFechaNac()+"-----------"+a.getCorreo()+"-------"
					+ a.getPais().getNamePais());
	}
	

}
