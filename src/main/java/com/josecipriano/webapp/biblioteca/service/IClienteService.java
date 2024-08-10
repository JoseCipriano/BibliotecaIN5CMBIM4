package com.josecipriano.webapp.biblioteca.service;

import java.util.List;

import com.josecipriano.webapp.biblioteca.model.Cliente;

public interface IClienteService {

    public List<Cliente> listarClientes();

    public Cliente guardarCliente(Cliente cliente);

    public Cliente buscarCliente(Long dpi);

    public void eliminarCliente(Cliente cliente);

}
