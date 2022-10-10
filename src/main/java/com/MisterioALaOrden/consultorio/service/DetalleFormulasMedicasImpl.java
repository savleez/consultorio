package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.DetalleFormulasMedicas;
import com.MisterioALaOrden.consultorio.model.DetalleFormulasMedicasId;
import com.MisterioALaOrden.consultorio.repository.DetalleFormulasMedicasRepository;

@Service
public class DetalleFormulasMedicasImpl implements DetalleFormulasMedicasService {
	@Autowired
	private DetalleFormulasMedicasRepository DetalleFormulasMedicasRepository;
	
	@Override
	@Transactional
	public List<DetalleFormulasMedicas> consultarDetalleFormulasMedicas() {
		List<DetalleFormulasMedicas> listaDetalleFormulasMedicas = (List<DetalleFormulasMedicas>) this.DetalleFormulasMedicasRepository.findAll();
		return listaDetalleFormulasMedicas;
	}

	@Override
	@Transactional
	public Optional<DetalleFormulasMedicas> consultarDetalleFormulasMedicasPorId(Integer id) {
		Optional<DetalleFormulasMedicas> respDetalleFormulasMedicas = this.DetalleFormulasMedicasRepository.findById(id);
		return respDetalleFormulasMedicas;
	}

	@Override
	@Transactional
	public DetalleFormulasMedicas guardarDetalleFormulasMedicas(DetalleFormulasMedicas DetalleFormulasMedicas) {
		DetalleFormulasMedicas newDetalleFormulasMedicas = this.DetalleFormulasMedicasRepository.save(DetalleFormulasMedicas);
		return newDetalleFormulasMedicas;
	}

	@Override
	@Transactional
	public void eliminarDetalleFormulasMedicas(Integer id) {
		this.DetalleFormulasMedicasRepository.deleteById(id);
	}

}
