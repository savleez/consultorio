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

import com.MisterioALaOrden.consultorio.model.Usuario;
import com.MisterioALaOrden.consultorio.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<?> getUsuarios(){
		List<Usuario> listaUsuarios = this.usuarioService.consultarUsuarios();
		return ResponseEntity.ok(listaUsuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuarioPorId(@PathVariable Integer id){
		Optional<Usuario> respUsuario = this.usuarioService.consultarUsuarioPorId(id);
		if (respUsuario.isPresent()) {
			return ResponseEntity.ok(respUsuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario paciente){
		Usuario newUsuario = this.usuarioService.guardarUsuario(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario paciente, @PathVariable Integer id){
		Optional<Usuario> respUsuario = this.usuarioService.consultarUsuarioPorId(id);
		if (respUsuario.isPresent()) {
			return ResponseEntity.ok(this.usuarioService.guardarUsuario(paciente));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Integer id){
		Optional<Usuario> respUsuario = this.usuarioService.consultarUsuarioPorId(id);
		if(respUsuario.isPresent()) {
			this.usuarioService.eliminarUsuario(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	
}