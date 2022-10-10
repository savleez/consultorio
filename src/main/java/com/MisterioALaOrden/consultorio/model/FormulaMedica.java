package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formulamedica")
public class FormulaMedica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5495963723884249170L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
