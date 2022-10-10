package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.DocumentacionHistoriaClinica;

public interface DocumentacionHistoriaClinicaService {
	public List<DocumentacionHistoriaClinica> consultarDocumentacionesHistoriaClinica();
	public Optional<DocumentacionHistoriaClinica> consultarDocumentacionHistoriaClinicaPorId(Integer id);
	public DocumentacionHistoriaClinica guardarDocumentacionHistoriaClinica(DocumentacionHistoriaClinica documentacion);
	public void eliminarDocumentacionHistoriaClinica(Integer id);
}
