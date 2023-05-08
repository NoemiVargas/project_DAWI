package com.proyecto.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_alu")
	private Integer codAlu;
	
	@Column(name ="nombre_alu")
	private String nomAlu;
	
	@Column(name="apellido_alu")
	private String apelliAlu;
	
	@Column(name="fecha_nac")
	private Date fechaNac;
	
	@Column(name="correo_alu")
	private String correo;
	
	@ManyToOne
	@JoinColumn(name="cod_pais") //BD
	private Pais pais; //VARIABLE

	public Integer getCodAlu() {
		return codAlu;
	}

	public void setCodAlu(Integer codAlu) {
		this.codAlu = codAlu;
	}

	public String getNomAlu() {
		return nomAlu;
	}

	public void setNomAlu(String nomAlu) {
		this.nomAlu = nomAlu;
	}

	public String getApelliAlu() {
		return apelliAlu;
	}

	public void setApelliAlu(String apelliAlu) {
		this.apelliAlu = apelliAlu;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	

}
