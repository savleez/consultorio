package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.Medicamentos;
import com.MisterioALaOrden.consultorio.repository.MedicamentosRepository;

@Service
public class MedicamentosServiceImpl implements MedicamentosService {
	@Autowired
	private MedicamentosRepository MedicamentosRepository;
	
	@Override
	@Transactional
	public List<Medicamentos> consultarMedicamentos() {
		List<Medicamentos> listaMedicamentos = this.MedicamentosRepository.findAll();
		return listaMedicamentos;
	}

	@Override
	@Transactional
	public Optional<Medicamentos> consultarMedicamentosPorId(Integer id) {
		Optional<Medicamentos> respMedicamentos = this.MedicamentosRepository.findById(id);
		return respMedicamentos;
	}

	@Override
	@Transactional
	public Medicamentos guardarMedicamentos(Medicamentos Medicamentos) {
		Medicamentos newMedicamentos = this.MedicamentosRepository.save(Medicamentos);
		return newMedicamentos;
	}

	@Override
	@Transactional
	public void eliminarMedicamentos(Integer id) {
		this.MedicamentosRepository.deleteById(id);
	}

}
