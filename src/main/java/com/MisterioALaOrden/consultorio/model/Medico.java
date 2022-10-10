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
import javax.persistence.Table;

@Entity
@Table(name="medico")
public class Medico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6808005458621421592L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	@Column(name="cedulaMedico",length = 20)
	private String cedulaMedico;
	@Column(name="nombreMedico",length = 45)
	private String nombreMedico;
	@Column(name="apellidoMedico",length = 45)
	private String apellidoMedico;
	@Column(name="correoMedico",length = 100)
	private String correoMedico;
	@Column(name="telefonoMedico",length = 45)
	private String telefonoMedico;
	@Column(name="numeroLicenciaMedico", length = 45)
	private String numeroLicenciaMedico;
	@Column(name="horarioEntradaMedico")
	private Date horarioEntradaMedico;
	@Column(name="horarioSalidaMedico")
	private Date horarioSalidaMedico;
	@Column(name="numeroConsultorio")
	private Integer numeroConsultorio;
	@ManyToOne
    @JoinColumn(name = "usuario")
	private Usuario usuario;
	

	public Medico() {
	}

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getCedulaMedico() {
		return cedulaMedico;
	}

	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getApellidoMedico() {
		return apellidoMedico;
	}

	public void setApellidoMedico(String apellidoMedico) {
		this.apellidoMedico = apellidoMedico;
	}

	public String getCorreoMedico() {
		return correoMedico;
	}

	public void setCorreoMedico(String correoMedico) {
		this.correoMedico = correoMedico;
	}

	public String getTelefonoMedico() {
		return telefonoMedico;
	}

	public void setTelefonoMedico(String telefonoMedico) {
		this.telefonoMedico = telefonoMedico;
	}

	public String getNumeroLicenciaMedico() {
		return numeroLicenciaMedico;
	}

	public void setNumeroLicenciaMedico(String numeroLicenciaMedico) {
		this.numeroLicenciaMedico = numeroLicenciaMedico;
	}

	public Date getHorarioEntradaMedico() {
		return horarioEntradaMedico;
	}

	public void setHorarioEntradaMedico(Date horarioEntradaMedico) {
		this.horarioEntradaMedico = horarioEntradaMedico;
	}

	public Date getHorarioSalidaMedico() {
		return horarioSalidaMedico;
	}

	public void setHorarioSalidaMedico(Date horarioSalidaMedico) {
		this.horarioSalidaMedico = horarioSalidaMedico;
	}

	public Integer getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(Integer numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}


