package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.Usuario;

public interface UsuarioService {
	public List<Usuario> consultarUsuarios();
	public Optional<Usuario> consultarUsuarioPorId(Integer id);
	public Usuario guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Integer id);
}
