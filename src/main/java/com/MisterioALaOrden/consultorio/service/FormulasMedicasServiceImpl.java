package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.FormulasMedicas;
import com.MisterioALaOrden.consultorio.repository.FormulasMedicasRepository;

@Service
public class FormulasMedicasServiceImpl implements FormulasMedicasService {
	
	@Autowired
	private FormulasMedicasRepository formulasMedicasRepository;
	
	@Override
	@Transactional
	public List<FormulasMedicas> consultarFormulasMedicas() {
		List<FormulasMedicas> listaFormulasMedicas = this.formulasMedicasRepository.findAll();
		return listaFormulasMedicas;
	}

	@Override
	@Transactional
	public Optional<FormulasMedicas> consultarFormulasMedicasPorId(Integer id) {
		Optional<FormulasMedicas> respFormulasMedicas = this.formulasMedicasRepository.findById(id);
		return respFormulasMedicas;
	}

	@Override
	@Transactional
	public FormulasMedicas guardarFormulasMedicas(FormulasMedicas FormulasMedicas) {
		FormulasMedicas newFormulasMedicas = this.formulasMedicasRepository.save(FormulasMedicas);
		return newFormulasMedicas;
	}

	@Override
	@Transactional
	public void eliminarFormulasMedicas(Integer id) {
		this.formulasMedicasRepository.deleteById(id);
	}

}
