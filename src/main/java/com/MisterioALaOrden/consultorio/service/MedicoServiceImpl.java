package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.Medico;
import com.MisterioALaOrden.consultorio.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {
	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public List<Medico> consultarMedicos() {
		List<Medico> listaMed = this.medicoRepository.findAll();
		return listaMed;
	}

	@Override
	public Optional<Medico> consultarMedicoPorId(Integer id) {
		Optional<Medico> respMed = this.medicoRepository.findById(id);
		return respMed;
	}

	@Override
	public Medico guardarMedico(Medico medico) {
		return this.medicoRepository.save(medico);
	}

	@Override
	public void eliminarMedico(Integer id) {
		this.medicoRepository.deleteById(id);
	}

}
