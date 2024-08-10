package com.josecipriano.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josecipriano.webapp.biblioteca.model.Empleado;
import com.josecipriano.webapp.biblioteca.service.EmpleadoService;

@Controller
@RestController
@RequestMapping(" ")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<Empleado> listarEmpleados(){
        return empleadoService.listarEmpleados();

    }


    @GetMapping("/empleado")
    public ResponseEntity<Empleado> buscarEmpleado(@RequestParam Long id){
        try {
            Empleado empleado = empleadoService.buscarEmpleado(id);
            return ResponseEntity.ok(empleado);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }



    }

    @PostMapping("/empleado")
    public ResponseEntity<Map<String, String>> agregarEmpleado(@RequestBody Empleado empleado){
        Map<String, String> response = new HashMap<>();
        try {
            empleadoService.guardarEmpleado(empleado);
            response.put("message", "Empleado creado con exito");
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {

             response.put("message", "Error");
             response.put("err", "Hubo un error al crear al Empleado");
             return  ResponseEntity.badRequest().body(response);
        }

    }


    @PutMapping("/empleado")
    public ResponseEntity<Map<String, String>> editarEmpleado(@RequestParam Long id, @RequestBody Empleado empleadoNuevo){
        Map<String, String> response = new HashMap<>();
        try {
            Empleado empleadoViejo = empleadoService.buscarEmpleado(id);
            empleadoViejo.setNombreEmpleado(empleadoNuevo.getNombreEmpleado());
            empleadoViejo.setApellidoEmpleado(empleadoNuevo.getApellidoEmpleado());
            empleadoViejo.setTelefonoEmpleado(empleadoNuevo.getTelefonoEmpleado());
            empleadoViejo.setDireccionEmpleado(empleadoNuevo.getDireccionEmpleado());
            empleadoViejo.setDpi(empleadoNuevo.getDpi());
            response.put("message", "El empleado ha sido modificado con exito");
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al modificar el Empleado");
            return ResponseEntity.badRequest().body(response);
        }


    }


    @DeleteMapping("/empleado")
    public ResponseEntity<Map<String,String>> eliminarEmpleado(@RequestParam Long id){
        Map<String ,String > response = new HashMap<>();
        try {
            Empleado empleado =  empleadoService.buscarEmpleado(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("message", "Se ha eliminado con exito ");
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "El empleado se ha eliminado con exito ");
            return ResponseEntity.badRequest().body(response);
        }



    }

}