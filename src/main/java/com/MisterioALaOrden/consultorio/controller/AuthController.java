package com.MisterioALaOrden.consultorio.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MisterioALaOrden.consultorio.model.Usuario;
import com.MisterioALaOrden.consultorio.service.UsuarioService;
import com.MisterioALaOrden.consultorio.util.JWTUtil;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping
	public ResponseEntity<?> createtoken(@RequestBody Usuario usuarioDetalle){
    	Optional<Usuario> respUsuario = this.usuarioService.consultarUsuarioPorId(usuarioDetalle.getId());
		if (respUsuario.isPresent()) {
			String tokenJwt = jwtUtil.getJWTToken(respUsuario.get().getId()+"");
            return ResponseEntity.ok(new JSONObject().put("access", tokenJwt.replace("Bearer ", "")).toString());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}