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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josecipriano.webapp.biblioteca.model.Libro;
import com.josecipriano.webapp.biblioteca.service.LibroService;

@Controller
@RestController
@RequestMapping

public class LIbroController {

    @Autowired
    LibroService libroService;

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> listarLibros(){
       try {
        return ResponseEntity.ok(libroService.listarLibros());
        
       } catch (Exception e) {
        return ResponseEntity.badRequest().body(null);
       }
     }

    

    @GetMapping("/libro")
    public ResponseEntity<Libro> buscarLibroPorId(@RequestParam Long id){
        try {
            return ResponseEntity.ok(libroService.buscaLibroPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);

        }

    }


    @PostMapping("/libro")
    public ResponseEntity<Map<String, String>> agregarLIbro(@RequestBody Libro libro){
        Map<String, String> response = new HashMap<>();
        try {
            libroService.guardarLibro(libro);
            response.put("message", "LIbro creado con exito");
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un errror al crear el libro.");
            return ResponseEntity.badRequest().body(response);
        }

        
    }

    @GetMapping("/libro")
    public ResponseEntity<Map<String, String>> editarLibro(@RequestParam Long id, @RequestBody Libro libroNuevo){
    Map <String, String> response = new HashMap<>();
    try {
        Libro libro = libroService.buscaLibroPorId(id);
        libro.setAutor(libroNuevo.getAutor());
        libro.setCategoria(libroNuevo.getCategoria());
        libro.setCluster(libroNuevo.getCluster());
        libro.setDisponibilidad(libroNuevo.getDisponibilidad());
        libro.setEditorial(libroNuevo.getEditorial());
        libro.setIsbn(libroNuevo.getIsbn());
        libro.setNombre(libroNuevo.getNombre());
        libro.setNumeroEstanteria(libroNuevo.getNumeroEstanteria());
        libro.setSinopsis(libroNuevo.getSinopsis());
        libroService.guardarLibro(libro);
        response.put("message", "Libro modificado con exito");
        return ResponseEntity.ok(response);

    } catch (Exception e) {
        response.put("message", "Error");
        response.put("err", "Hubo error al editar el libro");
        return ResponseEntity.badRequest().body(response);

    }
}

    @DeleteMapping("/libro")
    public ResponseEntity<Map<String,String>> eliminarLibro(@RequestParam Long id){
        Map<String, String> response = new HashMap<>();
        try {
            Libro libro = libroService.buscaLibroPorId(id);
            libroService.eliminarLibro(libro);
            response.put("message", "Libro eliminado con exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al modificar el libro");
            return ResponseEntity.badRequest().body(response);


        }




    }





}