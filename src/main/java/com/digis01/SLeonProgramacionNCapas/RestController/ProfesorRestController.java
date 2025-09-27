/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.RestController;

import com.digis01.SLeonProgramacionNCapas.JPA.Profesor;
import com.digis01.SLeonProgramacionNCapas.ML.Result;
import com.digis01.SLeonProgramacionNCapas.Service.ProfesorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    
}
