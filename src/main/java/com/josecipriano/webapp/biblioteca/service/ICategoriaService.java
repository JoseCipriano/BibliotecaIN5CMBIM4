package com.josecipriano.webapp.biblioteca.service;

import java.util.List;

import com.josecipriano.webapp.biblioteca.model.Categoria;

public interface ICategoriaService {

    public List<Categoria> listarCategorias();

    public Categoria guardarCategoria(Categoria categoria);

    public Categoria buscarCategoriaId(Long id);

    public void eliminarCategoria(Categoria categoria);

}
