package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MisterioALaOrden.consultorio.model.Usuario;
import com.MisterioALaOrden.consultorio.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public List<Usuario> consultarUsuarios() {
		List<Usuario> listaUsuarios = this.usuarioRepository.findAll();
		return listaUsuarios;
	}

	@Override
	@Transactional
	public Optional<Usuario> consultarUsuarioPorId(Integer id) {
		Optional<Usuario> respUsuario = this.usuarioRepository.findById(id);
		return respUsuario;
	}

	@Override
	@Transactional
	public Usuario guardarUsuario(Usuario usuario) {
		Usuario newUsuario = this.usuarioRepository.save(usuario);
		return newUsuario;
	}

	@Override
	@Transactional
	public void eliminarUsuario(Integer id) {
		this.usuarioRepository.deleteById(id);
	}

}
