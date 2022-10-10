package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medicamentos")
public class Medicamentos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3476844074233597509L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedicamentos;
	
	@Column(name = "nombreMedicamento", length = 45)
	private String nombreMedicamento;
	
	@Column(name = "laboratorio", length = 45)
	private String laboratorio;
	
	@Column(name = "precioUnitario", length = 45)
	private float precioUnitario;
	
	@Column(name = "existencias", length = 45)
	private int existencias;
	


}
