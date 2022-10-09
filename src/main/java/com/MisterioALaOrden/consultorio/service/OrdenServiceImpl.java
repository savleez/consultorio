package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.Orden;
import com.MisterioALaOrden.consultorio.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository ordenRepository;
	
	@Override
	@Transactional
	public List<Orden> consultarOrdenes() {
		List<Orden> listaOrdenes = this.ordenRepository.findAll();
		return listaOrdenes;
	}

	@Override
	@Transactional
	public Optional<Orden> consultarOrdenPorId(Integer id) {
		Optional<Orden> respOrden = this.ordenRepository.findById(id);
		return respOrden;
	}

	@Override
	@Transactional
	public Orden guardarOrden(Orden usuario) {
		Orden newOrden = this.ordenRepository.save(usuario);
		return newOrden;
	}

	@Override
	@Transactional
	public void eliminarOrden(Integer id) {
		this.ordenRepository.deleteById(id);
	}

}
