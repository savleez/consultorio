package com.MisterioALaOrden.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MisterioALaOrden.consultorio.model.FormulasMedicas;

@Repository
public interface FormulasMedicasRepository extends JpaRepository<FormulasMedicas, Integer> {

}
