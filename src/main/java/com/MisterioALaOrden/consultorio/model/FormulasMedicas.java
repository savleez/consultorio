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
@Table(name = "FormulasMedicas")
public class FormulasMedicas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7606028547201465789L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormulasMedicas;
	
	
	@Column(name = "vigenciaFormula")
	private Date vigenciaFormula;
	
	
	@Column(name = "estado", length = 45)
	private String estado;


	
	
	
	public FormulasMedicas() {
	}


	public Integer getIdFormulasMedicas() {
		return idFormulasMedicas;
	}


	public void setIdFormulasMedicas(Integer idFormulasMedicas) {
		this.idFormulasMedicas = idFormulasMedicas;
	}


	public Date getVigenciaFormula() {
		return vigenciaFormula;
	}


	public void setVigenciaFormula(Date vigenciaFormula) {
		this.vigenciaFormula = vigenciaFormula;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

}
