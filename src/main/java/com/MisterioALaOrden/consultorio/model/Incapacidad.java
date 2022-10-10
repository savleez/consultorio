package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incapacidad")
public class Incapacidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8536374466023325875L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fechaexpedicionincapacidad")
	private Date fechaexpedicionincapacidad;
	
	@Column(name = "vigencia")
	private Integer vigencia;
	
	@Column(name = "comentarios", length = 50)
	private String comentarios;

	public Incapacidad() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaexpedicionincapacidad() {
		return fechaexpedicionincapacidad;
	}

	public void setFechaexpedicionincapacidad(Date fechaexpedicionincapacidad) {
		this.fechaexpedicionincapacidad = fechaexpedicionincapacidad;
	}

	public Integer getVigencia() {
		return vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	


}
