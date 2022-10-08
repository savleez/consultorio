package com.MisterioALaOrden.consultorio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "password", length = 45)
	private String password;
	
	@Column(name = "fechaHoraCreacion")
	private Date fechaHoraCreacion;
	
	@Column(name = "tipo", length = 45)
	private String tipo;
	
	@Column(name = "estado", length = 45)
	private String estado;
}
