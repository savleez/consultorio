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

import com.MisterioALaOrden.consultorio.model.Medicamentos;
import com.MisterioALaOrden.consultorio.service.MedicamentosService;

@RestController
@RequestMapping("/api/Medicamentos")
public class MedicamentosController {
	@Autowired
	private MedicamentosService MedicamentosService;
	
	@GetMapping
	public ResponseEntity<?> getMedicamentoss(){
		List<Medicamentos> listaMedicamentos = this.MedicamentosService.consultarMedicamentos();
		return ResponseEntity.ok(listaMedicamentos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMedicamentosPorId(@PathVariable Integer id){
		Optional<Medicamentos> respMedicamentos = this.MedicamentosService.consultarMedicamentosPorId(id);
		if (respMedicamentos.isPresent()) {
			return ResponseEntity.ok(respMedicamentos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearMedicamentos(@RequestBody Medicamentos Medicamentos){
		Medicamentos newMedicamentos = this.MedicamentosService.guardarMedicamentos(Medicamentos);
		return ResponseEntity.status(HttpStatus.CREATED).body(newMedicamentos);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMedicamentos(@RequestBody Medicamentos Medicamentos, @PathVariable Integer id){
		Optional<Medicamentos> respMedicamentos = this.MedicamentosService.consultarMedicamentosPorId(id);
		if (respMedicamentos.isPresent()) {
			return ResponseEntity.ok(this.MedicamentosService.guardarMedicamentos(Medicamentos));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMedicamentos(@PathVariable Integer id){
		Optional<Medicamentos> respMedicamentos = this.MedicamentosService.consultarMedicamentosPorId(id);
		if(respMedicamentos.isPresent()) {
			this.MedicamentosService.eliminarMedicamentos(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	

}
