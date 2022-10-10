package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.Medico;

public interface MedicoService {
	public List<Medico> consultarMedicos();
	public Optional<Medico> consultarMedicoPorId(Integer id);
	public Medico guardarMedico(Medico medico);
	public void eliminarMedico(Integer id);
}