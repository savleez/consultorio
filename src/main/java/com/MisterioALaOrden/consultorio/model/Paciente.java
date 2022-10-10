package com.MisterioALaOrden.consultorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9037859327273428391L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	@Column(name="cedulaPaciente",length = 20)
	private String cedulaPaciente;
	@Column(name="nombrePaciente",length = 45)
	private String nombrePaciente;
	@Column(name="apellidoPaciente",length = 45)
	private String apellidoPaciente;
	@Column(name="correoPaciente",length = 100)
	private String correoPaciente;
	@Column(name="telefonoPaciente",length = 45)
	private String telefonoPaciente;
	@Column(name="edadPaciente")
	private Integer edadPaciente;
	@OneToOne
    @JoinColumn(name = "usuario")
	private Usuario usuario;
	
	public Paciente() {
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return apellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}

	public String getCorreoPaciente() {
		return correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

	public String getTelefonoPaciente() {
		return telefonoPaciente;
	}

	public void setTelefonoPaciente(String telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public Integer getEdadPaciente() {
		return edadPaciente;
	}

	public void setEdadPaciente(Integer edadPaciente) {
		this.edadPaciente = edadPaciente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
