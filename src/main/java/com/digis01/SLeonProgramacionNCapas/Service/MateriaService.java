/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.Service;

import com.digis01.SLeonProgramacionNCapas.DAO.MateriaRepository;
import com.digis01.SLeonProgramacionNCapas.JPA.Materia;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class MateriaService {
    
     private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public List<Materia> getAll() {
        return materiaRepository.findAll();
    }

    public Materia getById(int id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
    }
}

    

