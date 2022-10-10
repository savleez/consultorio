package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.Cita;
import com.MisterioALaOrden.consultorio.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService{
	@Autowired
	private CitaRepository citaRepository;
	
	
	@Override
	@Transactional
	public List<Cita> consultarCitas() {
		List<Cita> listaCitas = this.citaRepository.findAll();
		return listaCitas;
	}

	@Override
	@Transactional
	public Optional<Cita> consultarCitaPorId(Integer id) {
		Optional<Cita> respCita = this.citaRepository.findById(id);
		return respCita;
	}

	@Override
	@Transactional
	public Cita guardarCita(Cita cita) {
		Cita newCita = this.citaRepository.save(cita);
		return newCita;
	}

	@Override
	@Transactional
	public void eliminarCita(Integer id) {
		this.citaRepository.deleteById(id);
	}

}