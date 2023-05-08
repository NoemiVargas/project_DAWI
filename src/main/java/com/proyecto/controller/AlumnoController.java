package com.proyecto.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Alumno;
import com.proyecto.entity.Pais;
import com.proyecto.services.AlumnoServices;
import com.proyecto.services.PaisServices;


@Controller
@RequestMapping("/alumno")//CONECTA CON HTML
public class AlumnoController {
	@Autowired
	private AlumnoServices serAlumno;
	
	@Autowired
	private PaisServices serPais;
	
	//LISTAR ALUMNOS
		@RequestMapping("/lista")
		public String index(Model model) {
			model.addAttribute("listaAlumnos", serAlumno.listarTodos());
			model.addAttribute("listaPaises", serPais.listarTodos());
			return "alumno";
		}

	@RequestMapping("/registrar")
		public String grabar( @RequestParam("codigo")Integer cod,
							  @RequestParam("nombre")String nombre,
							  @RequestParam("apellido")String apellido,
							  @RequestParam("fechaNac")Date fecha,
							  @RequestParam("correo")String correo,
							  @RequestParam("codPais")Integer codPais,
							  RedirectAttributes redirect){
			
				try {
					Alumno a=new Alumno();
					a.setNomAlu(nombre);
					a.setApelliAlu(apellido);
					a.setFechaNac(fecha);
					a.setCorreo(correo);
					
					Pais p=new Pais();
					p.setCodPais(codPais);
					
					//llave
					a.setPais(p);
					
					if(cod==0) {
						serAlumno.grabar(a);
						redirect.addFlashAttribute("MENSAJE","Alumno registrado");
					}//ACTUALIZAR ALUMNO
					else {
						a.setCodAlu(cod);
						serAlumno.grabar(a);
						redirect.addFlashAttribute("MENSAJE", "Alumno actualizado");
					}
					
				} catch (Exception e) {
					redirect.addFlashAttribute("MENSAJE","Error en el registro");
					e.printStackTrace();
				}
				return "redirect:/alumno/lista";
		}
		
		//ELIMINAR ALUMNO
		@RequestMapping("/eliminar")
		public String eliminarPorCodigo (@RequestParam("codigo")Integer cod,
											RedirectAttributes redirect) {
			serAlumno.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Alumno eliminado");
			return "redirect:/Alumno/lista";
		}
	
		//CONSULTAR ALUMNO
		@RequestMapping("/consultar")
		@ResponseBody
		public Alumno buscarPorCodigo(@RequestParam("codigo")Integer cod,
										RedirectAttributes redirect) {
			return serAlumno.buscarPorCodigo(cod);
		}
	

	
	
	
	

}
