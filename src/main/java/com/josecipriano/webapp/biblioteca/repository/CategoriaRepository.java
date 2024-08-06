package com.josecipriano.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josecipriano.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
