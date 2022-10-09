package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.Incapacidad;


public interface IncapacidadService {

	public List<Incapacidad> consultarIncapacidades();
	public Optional<Incapacidad> consultarIncapacidadPorId(Integer id);
	public Incapacidad guardarIncapacidad(Incapacidad incapacidad);
	public void eliminarIncapacidad(Integer id);
	
}
