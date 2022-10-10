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

import com.MisterioALaOrden.consultorio.model.Medico;
import com.MisterioALaOrden.consultorio.service.MedicoService;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping
	public ResponseEntity<?> getMedicos(){
		List<Medico> listaMedicos = this.medicoService.consultarMedicos();
		return ResponseEntity.ok(listaMedicos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMedicoPorId(@PathVariable Integer id){
		Optional<Medico> respMedico = this.medicoService.consultarMedicoPorId(id);
		if (respMedico.isPresent()) {
			return ResponseEntity.ok(respMedico);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearMedico(@RequestBody Medico medico){
		Medico newMedico = this.medicoService.guardarMedico(medico);
		return ResponseEntity.status(HttpStatus.CREATED).body(newMedico);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMedico(@RequestBody Medico medico, @PathVariable Integer id){
		Optional<Medico> respMedico = this.medicoService.consultarMedicoPorId(id);
		if (respMedico.isPresent()) {
			return ResponseEntity.ok(this.medicoService.guardarMedico(medico));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMedico(@PathVariable Integer id){
		Optional<Medico> respMedico = this.medicoService.consultarMedicoPorId(id);
		if(respMedico.isPresent()) {
			this.medicoService.eliminarMedico(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	
}