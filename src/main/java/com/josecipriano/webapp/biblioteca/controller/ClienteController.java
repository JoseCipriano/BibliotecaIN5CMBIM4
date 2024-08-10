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

import com.josecipriano.webapp.biblioteca.model.Cliente;
import com.josecipriano.webapp.biblioteca.service.ClienteService;

@Controller
@RestController
@RequestMapping(" ")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/cliente")
    public ResponseEntity<Cliente> buscarCliente(@RequestParam Long dpi){
        try {
            Cliente cliente = clienteService.buscarCliente(dpi);
            return ResponseEntity.ok(cliente);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @PostMapping("/cliente")
    public ResponseEntity<Map<String,String>> agregarCliente(@RequestBody Cliente cliente){
        Map<String, String> response = new HashMap<>();

        try {
            clienteService.guardarCliente(cliente);
            response.put("message", "El cliente ha sido creado con exito");
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al crear el cliente");
            return ResponseEntity.badRequest().body(response);
        }

     }

     @PutMapping("/categoria")
     public ResponseEntity<Map<String, String>> editarCliente(@RequestParam Long dpi, @RequestBody Cliente clienteNuevo){
        Map<String, String> response = new HashMap<>();

        try {
            Cliente clienteViejo = clienteService.buscarCliente(dpi);
            clienteViejo.setDpi(clienteNuevo.getDpi());
            clienteViejo.setNombreCliente(clienteNuevo.getNombreCliente());
            clienteViejo.setApellidoCliente(clienteNuevo.getApellidoCliente());
            clienteViejo.setTelefonoCliente(clienteNuevo.getTelefonoCliente());
            response.put("message", "Cliente modificado con exito");
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al modificar el Cliente");
            return ResponseEntity.badRequest().body(response);
        }

    }

    @DeleteMapping("/categoria")
    public ResponseEntity<Map<String,String>> eliminarCliente(@RequestParam Long dpi){
        Map<String,String> response = new HashMap<>();

        try {
            Cliente cliente = clienteService.buscarCliente(dpi);
            clienteService.eliminarCliente(cliente);
            response.put("message", "El cliente ha sido eliminado con exito");
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al eliminar el Cliente");
            return ResponseEntity.badRequest().body(response);

    }

}

}


