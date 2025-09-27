/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.Service;

import com.digis01.SLeonProgramacionNCapas.DAO.ProfesorRepository;
import com.digis01.SLeonProgramacionNCapas.JPA.Profesor;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class ProfesorService {
    
    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }
    
    public List<Profesor> buscarporMatricula(int idMateria){
        return profesorRepository.findByMateria_IdMateria(idMateria);
    }
    
    public List<Profesor> ListarTodos(){
        return profesorRepository.findAll();
    }
}