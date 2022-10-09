package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.DocumentacionHistoriaClinica;
import com.MisterioALaOrden.consultorio.repository.DocumentacionHistoriaClinicaRepository;

@Service
public class DocumentacionHistoriaClinicaServiceImpl implements DocumentacionHistoriaClinicaService{

	@Autowired
	private DocumentacionHistoriaClinicaRepository documentacionHistoriaClinicaRepository;
	
	@Override
	@Transactional
	public List<DocumentacionHistoriaClinica> consultarDocumentacionesHistoriaClinica() {
		List<DocumentacionHistoriaClinica> listaDocumentacionesHistoriaClinica = this.documentacionHistoriaClinicaRepository.findAll();
		return listaDocumentacionesHistoriaClinica;
	}

	@Override
	@Transactional
	public Optional<DocumentacionHistoriaClinica> consultarDocumentacionHistoriaClinicaPorId(Integer id) {
		Optional<DocumentacionHistoriaClinica> respDocumentacionHistoriaClinica = this.documentacionHistoriaClinicaRepository.findById(id);
		return respDocumentacionHistoriaClinica;
	}

	@Override
	@Transactional
	public DocumentacionHistoriaClinica guardarDocumentacionHistoriaClinica(DocumentacionHistoriaClinica documentacion) {
		DocumentacionHistoriaClinica newDocumentacionHistoriaClinica = this.documentacionHistoriaClinicaRepository.save(documentacion);
		return newDocumentacionHistoriaClinica;
	}

	@Override
	@Transactional
	public void eliminarDocumentacionHistoriaClinica(Integer id) {
		this.documentacionHistoriaClinicaRepository.deleteById(id);
	}

}
