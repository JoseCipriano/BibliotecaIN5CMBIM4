package com.josecipriano.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josecipriano.webapp.biblioteca.model.Empleado;

public interface EmpleadoRepository extends JpaRepository <Empleado, Long>{

}
