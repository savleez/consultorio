package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.Incapacidad;
import com.MisterioALaOrden.consultorio.repository.IncapacidadRepository;

@Service
public class IncapacidadServiceImpl implements IncapacidadService {

	@Autowired
	private IncapacidadRepository incapacidadRepository;
	
	
	@Override
	@Transactional
	public List<Incapacidad> consultarIncapacidades() {
		List<Incapacidad> listaIncapacidades = this.incapacidadRepository.findAll();
		return listaIncapacidades;
	}

	@Override
	@Transactional
	public Optional<Incapacidad> consultarIncapacidadPorId(Integer id) {
		Optional<Incapacidad> respIncapacidad = this.incapacidadRepository.findById(id);
		return respIncapacidad;
	}

	@Override
	@Transactional
	public Incapacidad guardarIncapacidad(Incapacidad usuario) {
		Incapacidad newIncapacidad = this.incapacidadRepository.save(usuario);
		return newIncapacidad;
	}

	@Override
	@Transactional
	public void eliminarIncapacidad(Integer id) {
		this.incapacidadRepository.deleteById(id);
	}

}
