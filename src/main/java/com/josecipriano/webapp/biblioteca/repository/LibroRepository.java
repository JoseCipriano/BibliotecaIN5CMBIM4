package com.josecipriano.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josecipriano.webapp.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository <Libro,Long> {

}
