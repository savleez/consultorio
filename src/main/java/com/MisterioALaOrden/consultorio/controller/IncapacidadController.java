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

import com.MisterioALaOrden.consultorio.model.Incapacidad;
import com.MisterioALaOrden.consultorio.service.IncapacidadService;


@RestController
@RequestMapping("/api/incapacidades")
public class IncapacidadController {

	
	@Autowired
	private IncapacidadService incapacidadService;
	
	@GetMapping
	public ResponseEntity<?> getIncapacidads(){
		List<Incapacidad> listaIncapacidades = this.incapacidadService.consultarIncapacidades();
		return ResponseEntity.ok(listaIncapacidades);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getIncapacidadPorId(@PathVariable Integer id){
		Optional<Incapacidad> respIncapacidad = this.incapacidadService.consultarIncapacidadPorId(id);
		if (respIncapacidad.isPresent()) {
			return ResponseEntity.ok(respIncapacidad);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearIncapacidad(@RequestBody Incapacidad usuario){
		Incapacidad newIncapacidad = this.incapacidadService.guardarIncapacidad(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(newIncapacidad);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateIncapacidad(@RequestBody Incapacidad usuario, @PathVariable Integer id){
		Optional<Incapacidad> respIncapacidad = this.incapacidadService.consultarIncapacidadPorId(id);
		if (respIncapacidad.isPresent()) {
			return ResponseEntity.ok(this.incapacidadService.guardarIncapacidad(usuario));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteIncapacidad(@PathVariable Integer id){
		Optional<Incapacidad> respIncapacidad = this.incapacidadService.consultarIncapacidadPorId(id);
		if(respIncapacidad.isPresent()) {
			this.incapacidadService.eliminarIncapacidad(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	
}
