package com.MisterioALaOrden.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MisterioALaOrden.consultorio.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

}
