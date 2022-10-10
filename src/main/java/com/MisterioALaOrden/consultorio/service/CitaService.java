package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.Cita;

public interface CitaService {
	public List<Cita> consultarCitas();
	public Optional<Cita> consultarCitaPorId(Integer id);
	public Cita guardarCita(Cita cita);
	public void eliminarCita(Integer id);
}
