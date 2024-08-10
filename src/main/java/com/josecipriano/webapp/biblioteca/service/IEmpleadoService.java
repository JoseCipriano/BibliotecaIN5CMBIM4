package com.josecipriano.webapp.biblioteca.service;

import java.util.List;

import com.josecipriano.webapp.biblioteca.model.Empleado;

public interface IEmpleadoService {

    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado buscarEmpleado(Long id);

    public void eliminarEmpleado(Empleado empleado);

}
