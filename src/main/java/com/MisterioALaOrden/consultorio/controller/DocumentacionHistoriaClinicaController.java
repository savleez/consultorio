package com.MisterioALaOrden.consultorio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MisterioALaOrden.consultorio.model.DocumentacionHistoriaClinica;
import com.MisterioALaOrden.consultorio.service.DocumentacionHistoriaClinicaService;

@RestController
@RequestMapping("/api/documentacioneshistoriaclinica")
public class DocumentacionHistoriaClinicaController {
	
	@Autowired
	private DocumentacionHistoriaClinicaService documentacionHistoriaClinicaService;
	
	@GetMapping
	public ResponseEntity<?> getDocumentacionesHistoriaClinica(){
		List<DocumentacionHistoriaClinica> listaDocumentacionesHistoriaClinica = this.documentacionHistoriaClinicaService.consultarDocumentacionesHistoriaClinica();
		return ResponseEntity.ok(listaDocumentacionesHistoriaClinica);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDocumentacionHistoriaClinicaPorId(@PathVariable Integer id){
		Optional<DocumentacionHistoriaClinica> respDocumentacionHistoriaClinica = this.documentacionHistoriaClinicaService.consultarDocumentacionHistoriaClinicaPorId(id);
		if (respDocumentacionHistoriaClinica.isPresent()) {
			return ResponseEntity.ok(respDocumentacionHistoriaClinica);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearDocumentacionHistoriaClinica(@RequestBody DocumentacionHistoriaClinica documentacion){
		DocumentacionHistoriaClinica newDocumentacionHistoriaClinica = this.documentacionHistoriaClinicaService.guardarDocumentacionHistoriaClinica(documentacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDocumentacionHistoriaClinica);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDocumentacionHistoriaClinica(@RequestBody DocumentacionHistoriaClinica usuario, @PathVariable Integer id){
		Optional<DocumentacionHistoriaClinica> respDocumentacionHistoriaClinica = this.documentacionHistoriaClinicaService.consultarDocumentacionHistoriaClinicaPorId(id);
		if (respDocumentacionHistoriaClinica.isPresent()) {
			return ResponseEntity.ok(this.documentacionHistoriaClinicaService.guardarDocumentacionHistoriaClinica(usuario));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDocumentacionHistoriaClinica(@PathVariable Integer id){
		Optional<DocumentacionHistoriaClinica> respDocumentacionHistoriaClinica = this.documentacionHistoriaClinicaService.consultarDocumentacionHistoriaClinicaPorId(id);
		if(respDocumentacionHistoriaClinica.isPresent()) {
			this.documentacionHistoriaClinicaService.eliminarDocumentacionHistoriaClinica(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}

}