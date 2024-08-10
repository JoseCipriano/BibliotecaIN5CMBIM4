package com.josecipriano.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josecipriano.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente ,Long> {

}
