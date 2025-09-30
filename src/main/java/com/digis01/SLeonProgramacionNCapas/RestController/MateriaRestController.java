/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.RestController;

import com.digis01.SLeonProgramacionNCapas.JPA.Materia;
import com.digis01.SLeonProgramacionNCapas.Service.MateriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/api/materias")
public class MateriaRestController {
    
    private final MateriaService materiaService;
    
    @Autowired
    public MateriaRestController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    // GET: Obtener todas las materias
    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias() {
        List<Materia> materias = materiaService.getAll();
        return ResponseEntity.ok(materias);
    }

    // GET: Obtener materia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable int id) {
        Materia materia = materiaService.getById(id);
        return ResponseEntity.ok(materia);
    }
    
}
