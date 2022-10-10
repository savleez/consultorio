package com.MisterioALaOrden.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MisterioALaOrden.consultorio.model.DocumentacionHistoriaClinica;


@Repository
public interface DocumentacionHistoriaClinicaRepository extends JpaRepository<DocumentacionHistoriaClinica, Integer>{

}
