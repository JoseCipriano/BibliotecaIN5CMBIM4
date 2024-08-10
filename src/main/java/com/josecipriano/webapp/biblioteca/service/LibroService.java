package com.josecipriano.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josecipriano.webapp.biblioteca.model.Libro;
import com.josecipriano.webapp.biblioteca.repository.LibroRepository;

@Service
public class LibroService implements ILibroService {

    @Autowired
    LibroRepository libroRepository;



    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
     }
     

    @Override
    public Libro buscaLibroPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
       return libroRepository.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
       libroRepository.delete(libro);
    }

}
