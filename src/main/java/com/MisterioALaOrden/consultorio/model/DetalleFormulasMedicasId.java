package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;

public class DetalleFormulasMedicasId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3066188016515056014L;
	private Integer FormulasMedicas;
	private Integer Medicamentos;
	
	public Integer getIdFormulasMedicas() {
		return FormulasMedicas;
	}
	public void setIdFormulasMedicas(Integer idFormulasMedicas) {
		this.FormulasMedicas = idFormulasMedicas;
	}
	public Integer getIdMedicamentos() {
		return Medicamentos;
	}
	public void setIdMedicamentos(Integer idMedicamentos) {
		this.Medicamentos = idMedicamentos;
	}
	public DetalleFormulasMedicasId(Integer idFormulasMedicas, Integer idMedicamentos) {
		super();
		this.FormulasMedicas = idFormulasMedicas;
		this.Medicamentos = idMedicamentos;
	}
	

}
