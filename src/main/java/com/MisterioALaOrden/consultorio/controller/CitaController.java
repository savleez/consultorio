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

import com.MisterioALaOrden.consultorio.model.Cita;
import com.MisterioALaOrden.consultorio.service.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

	
	@Autowired
	private CitaService citaService;
	
	@GetMapping
	public ResponseEntity<?> getCitas(){
		List<Cita> listaCitas = this.citaService.consultarCitas();
		return ResponseEntity.ok(listaCitas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCitaPorId(@PathVariable Integer id){
		Optional<Cita> respCita = this.citaService.consultarCitaPorId(id);
		if (respCita.isPresent()) {
			return ResponseEntity.ok(respCita);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearCita(@RequestBody Cita cita){
		Cita newCita = this.citaService.guardarCita(cita);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCita);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCita(@RequestBody Cita cita, @PathVariable Integer id){
		Optional<Cita> respCita = this.citaService.consultarCitaPorId(id);
		if (respCita.isPresent()) {
			return ResponseEntity.ok(this.citaService.guardarCita(cita));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCita(@PathVariable Integer id){
		Optional<Cita> respCita = this.citaService.consultarCitaPorId(id);
		if(respCita.isPresent()) {
			this.citaService.eliminarCita(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	
}