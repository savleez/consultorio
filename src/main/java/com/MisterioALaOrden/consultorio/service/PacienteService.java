package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.Paciente;

public interface PacienteService {
	public List<Paciente> consultarPacientes();
	public Optional<Paciente> consultarPacientePorId(Integer id);
	public Paciente guardarPaciente(Paciente Paciente);
	public void eliminarPaciente(Integer id);
}
