package com.josecipriano.webapp.biblioteca.service;

import java.util.List;

import com.josecipriano.webapp.biblioteca.model.Libro;

public interface ILibroService {

    public List<Libro> listarLibros();

    public Libro buscaLibroPorId(Long id);

    public Libro guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);

}
