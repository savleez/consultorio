package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.Paciente;
import com.MisterioALaOrden.consultorio.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{
	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	@Override
	@Transactional
	public List<Paciente> consultarPacientes() {
		List<Paciente> listaPacientes = this.pacienteRepository.findAll();
		return listaPacientes;
	}

	@Override
	@Transactional
	public Optional<Paciente> consultarPacientePorId(Integer id) {
		Optional<Paciente> respPaciente = this.pacienteRepository.findById(id);
		return respPaciente;
	}

	@Override
	@Transactional
	public Paciente guardarPaciente(Paciente paciente) {
		Paciente newPaciente = this.pacienteRepository.save(paciente);
		return newPaciente;
	}

	@Override
	@Transactional
	public void eliminarPaciente(Integer id) {
		this.pacienteRepository.deleteById(id);
	}

}
