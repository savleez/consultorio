package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "cita")
public class Cita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7176717000545045335L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
    @JoinColumn(name = "paciente")
	private Paciente paciente;
	@ManyToOne
    @JoinColumn(name = "medico")
	private Medico medico;
    @Column(name = "fechaHoraCita")
	private Date fechaHoraCita;
    @Column(name = "estadoCita", length = 45)
	private String estadoCita;
    @Column(name = "costoCita")
	private Float costoCita;
    @Column(name = "tipoCita", length = 45)
	private String tipoCita;

    
	public Cita() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getFechaHoraCita() {
		return fechaHoraCita;
	}

	public void setFechaHoraCita(Date fechaHoraCita) {
		this.fechaHoraCita = fechaHoraCita;
	}

	public String getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}

	public Float getCostoCita() {
		return costoCita;
	}

	public void setCostoCita(Float costoCita) {
		this.costoCita = costoCita;
	}

	public String getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(String tipoCita) {
		this.tipoCita = tipoCita;
	}

    
}
