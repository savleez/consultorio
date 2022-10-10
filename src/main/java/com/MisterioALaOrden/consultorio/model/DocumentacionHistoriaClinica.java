package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documentacionhistoriaclinica")
public class DocumentacionHistoriaClinica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2580078498801755988L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cedulaPaciente", length = 20)
	private String cedulaPaciente;
	
	@Column(name = "cedulaMedico", length = 20)
	private String cedulaMedico;
	
	@OneToOne
    @JoinColumn(name = "incapacidad")
	private Incapacidad incapacidad;
	
	@ManyToOne
    @JoinColumn(name = "cita")
	private Cita cita;
	
	@OneToOne
    @JoinColumn(name = "formulasMedicas")
	private FormulasMedicas formulasMedicas;
	
	@OneToOne
    @JoinColumn(name = "orden")
	private Orden orden;

	public DocumentacionHistoriaClinica() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public String getCedulaMedico() {
		return cedulaMedico;
	}

	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	public Incapacidad getIncapacidad() {
		return incapacidad;
	}

	public void setIncapacidad(Incapacidad incapacidad) {
		this.incapacidad = incapacidad;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public FormulasMedicas getFormulasMedicas() {
		return formulasMedicas;
	}

	public void setFormulasMedicas(FormulasMedicas formulasMedicas) {
		this.formulasMedicas = formulasMedicas;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	

}
