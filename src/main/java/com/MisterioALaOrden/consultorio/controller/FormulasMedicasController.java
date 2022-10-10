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

import com.MisterioALaOrden.consultorio.model.FormulasMedicas;
import com.MisterioALaOrden.consultorio.service.FormulasMedicasService;

@RestController
@RequestMapping("/api/FormulasMedicas")
public class FormulasMedicasController {
	@Autowired
	private FormulasMedicasService FormulasMedicasService;
	
	@GetMapping
	public ResponseEntity<?> getFormulasMedicass(){
		List<FormulasMedicas> listaFormulasMedicas = this.FormulasMedicasService.consultarFormulasMedicas();
		return ResponseEntity.ok(listaFormulasMedicas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFormulasMedicasPorId(@PathVariable Integer id){
		Optional<FormulasMedicas> respFormulasMedicas = this.FormulasMedicasService.consultarFormulasMedicasPorId(id);
		if (respFormulasMedicas.isPresent()) {
			return ResponseEntity.ok(respFormulasMedicas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearFormulasMedicas(@RequestBody FormulasMedicas FormulasMedicas){
		FormulasMedicas newFormulasMedicas = this.FormulasMedicasService.guardarFormulasMedicas(FormulasMedicas);
		return ResponseEntity.status(HttpStatus.CREATED).body(newFormulasMedicas);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateFormulasMedicas(@RequestBody FormulasMedicas FormulasMedicas, @PathVariable Integer id){
		Optional<FormulasMedicas> respFormulasMedicas = this.FormulasMedicasService.consultarFormulasMedicasPorId(id);
		if (respFormulasMedicas.isPresent()) {
			return ResponseEntity.ok(this.FormulasMedicasService.guardarFormulasMedicas(FormulasMedicas));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFormulasMedicas(@PathVariable Integer id){
		Optional<FormulasMedicas> respFormulasMedicas = this.FormulasMedicasService.consultarFormulasMedicasPorId(id);
		if(respFormulasMedicas.isPresent()) {
			this.FormulasMedicasService.eliminarFormulasMedicas(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}

}
