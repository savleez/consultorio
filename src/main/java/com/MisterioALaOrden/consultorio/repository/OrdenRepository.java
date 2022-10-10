package com.MisterioALaOrden.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MisterioALaOrden.consultorio.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{

}
