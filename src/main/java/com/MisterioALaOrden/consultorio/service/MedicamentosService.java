package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.Medicamentos;

public interface MedicamentosService {
	public List<Medicamentos> consultarMedicamentos();
	public Optional<Medicamentos> consultarMedicamentosPorId(Integer id);
	public Medicamentos guardarMedicamentos(Medicamentos Medicamentos);
	public void eliminarMedicamentos(Integer id);
}
