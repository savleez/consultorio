package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.DetalleFormulasMedicas;
import com.MisterioALaOrden.consultorio.model.DetalleFormulasMedicasId;

public interface DetalleFormulasMedicasService {
	public List<DetalleFormulasMedicas> consultarDetalleFormulasMedicas();
	public Optional<DetalleFormulasMedicas> consultarDetalleFormulasMedicasPorId(Integer idDetalleFormulaMedica);
	public DetalleFormulasMedicas guardarDetalleFormulasMedicas(DetalleFormulasMedicas DetalleformulaMedica);
	public void eliminarDetalleFormulasMedicas(Integer idDetalleFormulaMedica);

}
