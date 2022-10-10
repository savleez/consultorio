package com.MisterioALaOrden.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MisterioALaOrden.consultorio.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
