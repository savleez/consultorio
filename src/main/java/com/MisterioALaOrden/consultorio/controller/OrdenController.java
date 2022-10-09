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

import com.MisterioALaOrden.consultorio.model.Orden;
import com.MisterioALaOrden.consultorio.service.OrdenService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {
	
	@Autowired
	private OrdenService ordenService;
	
	@GetMapping
	public ResponseEntity<?> getOrdenes(){
		List<Orden> listaOrdenes = this.ordenService.consultarOrdenes();
		return ResponseEntity.ok(listaOrdenes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrdenPorId(@PathVariable Integer id){
		Optional<Orden> respOrden = this.ordenService.consultarOrdenPorId(id);
		if (respOrden.isPresent()) {
			return ResponseEntity.ok(respOrden);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearOrden(@RequestBody Orden usuario){
		Orden newOrden = this.ordenService.guardarOrden(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(newOrden);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateOrden(@RequestBody Orden usuario, @PathVariable Integer id){
		Optional<Orden> respOrden = this.ordenService.consultarOrdenPorId(id);
		if (respOrden.isPresent()) {
			return ResponseEntity.ok(this.ordenService.guardarOrden(usuario));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrden(@PathVariable Integer id){
		Optional<Orden> respOrden = this.ordenService.consultarOrdenPorId(id);
		if(respOrden.isPresent()) {
			this.ordenService.eliminarOrden(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}

}