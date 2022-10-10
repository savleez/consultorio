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

import com.MisterioALaOrden.consultorio.model.Paciente;
import com.MisterioALaOrden.consultorio.service.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<?> getPacientes(){
		List<Paciente> listaPacientes = this.pacienteService.consultarPacientes();
		return ResponseEntity.ok(listaPacientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPacientePorId(@PathVariable Integer id){
		Optional<Paciente> respPaciente = this.pacienteService.consultarPacientePorId(id);
		if (respPaciente.isPresent()) {
			return ResponseEntity.ok(respPaciente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente){
		Paciente newPaciente = this.pacienteService.guardarPaciente(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPaciente);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePaciente(@RequestBody Paciente paciente, @PathVariable Integer id){
		Optional<Paciente> respPaciente = this.pacienteService.consultarPacientePorId(id);
		if (respPaciente.isPresent()) {
			return ResponseEntity.ok(this.pacienteService.guardarPaciente(paciente));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePaciente(@PathVariable Integer id){
		Optional<Paciente> respPaciente = this.pacienteService.consultarPacientePorId(id);
		if(respPaciente.isPresent()) {
			this.pacienteService.eliminarPaciente(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	
}