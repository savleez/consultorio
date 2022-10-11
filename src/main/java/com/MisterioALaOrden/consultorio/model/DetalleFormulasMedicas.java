package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@IdClass(value = DetalleFormulasMedicasId.class)
@Entity
@Table(name = "DetalleFormulasMedicas")
public class DetalleFormulasMedicas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1176722169188440862L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="FormulasMedicas")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private FormulasMedicas FormulasMedicas;

	@ManyToOne
	@JoinColumn(name="Medicamentos")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Medicamentos Medicamentos;
	
	@Column(name = "comentarios", length = 300)
	private String comentarios;

	
	
	public DetalleFormulasMedicas() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public FormulasMedicas getFormulasMedicas() {
		return FormulasMedicas;
	}



	public void setFormulasMedicas(FormulasMedicas formulasMedicas) {
		FormulasMedicas = formulasMedicas;
	}



	public Medicamentos getMedicamentos() {
		return Medicamentos;
	}



	public void setMedicamentos(Medicamentos medicamentos) {
		Medicamentos = medicamentos;
	}



	public String getComentarios() {
		return comentarios;
	}



	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	
}
