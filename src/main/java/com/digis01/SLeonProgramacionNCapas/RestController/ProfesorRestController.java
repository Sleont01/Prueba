/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.RestController;

import com.digis01.SLeonProgramacionNCapas.JPA.Profesor;
import com.digis01.SLeonProgramacionNCapas.ML.Result;
import com.digis01.SLeonProgramacionNCapas.Service.ProfesorService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/api/profesores")
public class ProfesorRestController {
    
    private final ProfesorService profesorService;
    
    @Autowired
    public ProfesorRestController(ProfesorService profesorService){
        this.profesorService = profesorService;
    }
    
    @GetMapping
    public ResponseEntity<Result> Getall(){
        Result result = new Result();
        try{
            List<Profesor> profesores = profesorService.ListarTodos();
            result.correct = true;
            result.object = profesores;
            
            return ResponseEntity.status(200).body(result);
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage= ex.getLocalizedMessage();
            
            return ResponseEntity.status(500).body(result);
            
        
        }
    }
    
    // GET /api/profesores/{id} -> obtener profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getProfesorPorId(@PathVariable int id) {
        Profesor profesor = profesorService.obtenerPorId(id);
        return ResponseEntity.ok(profesor);
    }
    
    // POST /api/profesores -> crear profesor
    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor creado = profesorService.crearProfesor(profesor);
        return ResponseEntity.status(201).body(creado);
    }

    // PUT /api/profesores/{id} -> reemplazar completamente
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> reemplazarProfesor(@PathVariable int id, @RequestBody Profesor profesor) {
        Profesor actualizado = profesorService.reemplazarProfesor(id, profesor);
        return ResponseEntity.ok(actualizado);
    }

    // PATCH /api/profesores/{id} -> actualizar parcialmente
    @PatchMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable int id, @RequestBody Map<String, Object> cambios) {
        Profesor actualizado = profesorService.actualizarProfesor(id, cambios);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE /api/profesores/{id} -> eliminar profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable int id) {
        profesorService.eliminarProfesor(id);
        return ResponseEntity.noContent().build();
    }

    

    
    
    
}
