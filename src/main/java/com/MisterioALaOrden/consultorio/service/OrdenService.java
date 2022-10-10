package com.MisterioALaOrden.consultorio.service;

import java.util.List;
import java.util.Optional;

import com.MisterioALaOrden.consultorio.model.Orden;

public interface OrdenService {
	public List<Orden> consultarOrdenes();
	public Optional<Orden> consultarOrdenPorId(Integer id);
	public Orden guardarOrden(Orden usuario);
	public void eliminarOrden(Integer id);
}
