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

import com.MisterioALaOrden.consultorio.model.DetalleFormulasMedicas;
import com.MisterioALaOrden.consultorio.service.DetalleFormulasMedicasService;

@RestController
@RequestMapping("/api/DetalleFormulasMedicas")
public class DetalleFormulasMedicasController {
	@Autowired
	private DetalleFormulasMedicasService DetalleFormulasMedicasService;
	
	@GetMapping
	public ResponseEntity<?> getDetalleFormulasMedicass(){
		List<DetalleFormulasMedicas> listaDetalleFormulasMedicas = this.DetalleFormulasMedicasService.consultarDetalleFormulasMedicas();
		return ResponseEntity.ok(listaDetalleFormulasMedicas);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDetalleFormulasMedicasPorId(@PathVariable Integer id){
		Optional<DetalleFormulasMedicas> respDetalleFormulasMedicas = this.DetalleFormulasMedicasService.consultarDetalleFormulasMedicasPorId(id);
		if (respDetalleFormulasMedicas.isPresent()) {
			return ResponseEntity.ok(respDetalleFormulasMedicas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> crearDetalleFormulasMedicas(@RequestBody DetalleFormulasMedicas DetalleFormulasMedicas){
		DetalleFormulasMedicas newDetalleFormulasMedicas = this.DetalleFormulasMedicasService.guardarDetalleFormulasMedicas(DetalleFormulasMedicas);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDetalleFormulasMedicas);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDetalleFormulasMedicas(@RequestBody DetalleFormulasMedicas DetalleFormulasMedicas, @PathVariable Integer id){
		Optional<DetalleFormulasMedicas> respDetalleFormulasMedicas = this.DetalleFormulasMedicasService.consultarDetalleFormulasMedicasPorId(id);
		if (respDetalleFormulasMedicas.isPresent()) {
			return ResponseEntity.ok(this.DetalleFormulasMedicasService.guardarDetalleFormulasMedicas(DetalleFormulasMedicas));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDetalleFormulasMedicas(@PathVariable Integer id){
		Optional<DetalleFormulasMedicas> respDetalleFormulasMedicas = this.DetalleFormulasMedicasService.consultarDetalleFormulasMedicasPorId(id);
		if(respDetalleFormulasMedicas.isPresent()) {
			this.DetalleFormulasMedicasService.eliminarDetalleFormulasMedicas(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	

}
