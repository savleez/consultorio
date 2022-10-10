package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.FormulasMedicas;

public interface FormulasMedicasService {
	public List<FormulasMedicas> consultarFormulasMedicas();
	public Optional<FormulasMedicas> consultarFormulasMedicasPorId(Integer idFormulaMedica);
	public FormulasMedicas guardarFormulasMedicas(FormulasMedicas formulaMedica);
	public void eliminarFormulasMedicas(Integer idFormulaMedica);

}
