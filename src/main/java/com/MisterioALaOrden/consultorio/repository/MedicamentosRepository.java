package com.MisterioALaOrden.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MisterioALaOrden.consultorio.model.Medicamentos;

public interface MedicamentosRepository extends JpaRepository<Medicamentos, Integer> {

}
