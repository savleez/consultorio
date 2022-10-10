package com.MisterioALaOrden.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MisterioALaOrden.consultorio.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
