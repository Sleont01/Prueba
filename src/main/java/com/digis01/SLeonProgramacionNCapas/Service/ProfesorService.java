/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.Service;

import com.digis01.SLeonProgramacionNCapas.DAO.ProfesorRepository;
import com.digis01.SLeonProgramacionNCapas.JPA.Profesor;
import com.digis01.SLeonProgramacionNCapas.JPA.Materia;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
    
@Service
public class ProfesorService {
    
    private final ProfesorRepository profesorRepository;
    private final MateriaService materiaService;

    public ProfesorService(ProfesorRepository profesorRepository, MateriaService materiaService) {
        this.profesorRepository = profesorRepository;
        this.materiaService = materiaService;
    }
    
    public List<Profesor> buscarporMateria(int idMateria){
        return profesorRepository.findByMateria_IdMateria(idMateria);
    }
    
    public List<Profesor> ListarTodos(){
        return profesorRepository.findAll();
    }
    
    public Profesor obtenerPorId(int id) {
    return profesorRepository.findById(id)
            .orElse(null); 
}
    public Profesor crearProfesor(Profesor profesor) {
       
        if (profesor.getMateria() != null && profesor.getMateria().getIdMateria() != 0) {
            Materia materia = materiaService.getById(profesor.getMateria().getIdMateria());
            profesor.setMateria(materia);
        }
        return profesorRepository.save(profesor);
    }

     public Profesor reemplazarProfesor(int id, Profesor profesor) {
        return profesorRepository.findById(id)
                .map(p -> {
                    p.setNombre(profesor.getNombre());
                    p.setApellidoPaterno(profesor.getApellidoPaterno());
                    p.setApellidoMaterno(profesor.getApellidoMaterno());
                    p.setEmail(profesor.getEmail());
                    p.setPassword(profesor.getPassword());
                    p.setTelefono(profesor.getTelefono());
                    p.setCelular(profesor.getCelular());
                    p.setFechaIngreso(profesor.getFechaIngreso());
                    p.setMateria(profesor.getMateria());
                    p.setMatricula(profesor.getMatricula());
                    return profesorRepository.save(p);
                })
                .orElseGet(() -> {
                    profesor.setIdProfesor(id);
                    return profesorRepository.save(profesor);
                });
    }

  public Profesor actualizarProfesor(int id, Map<String, Object> cambios) {
    Profesor profesor = profesorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

    if (cambios.containsKey("nombre")) {
        profesor.setNombre((String) cambios.get("nombre"));
    }
    if (cambios.containsKey("apellidoPaterno")) {
        profesor.setApellidoPaterno((String) cambios.get("apellidoPaterno"));
    }
    if (cambios.containsKey("apellidoMaterno")) {
        profesor.setApellidoMaterno((String) cambios.get("apellidoMaterno"));
    }
    if (cambios.containsKey("email")) {
        profesor.setEmail((String) cambios.get("email"));
    }
    if (cambios.containsKey("password")) {
        profesor.setPassword((String) cambios.get("password"));
    }
    if (cambios.containsKey("telefono")) {
        profesor.setTelefono((String) cambios.get("telefono"));
    }
    if (cambios.containsKey("celular")) {
        profesor.setCelular((String) cambios.get("celular"));
    }
    if (cambios.containsKey("fechaIngreso")) {
        profesor.setFechaIngreso((Date) cambios.get("fechaIngreso"));
    }
    if (cambios.containsKey("materiaId")) {
        int idMateria = (Integer) cambios.get("materiaId");
        Materia materia = materiaService.getById(idMateria);
        profesor.setMateria(materia);
    }
    if (cambios.containsKey("matricula")) {
        profesor.setMatricula((String) cambios.get("matricula"));
    }

    return profesorRepository.save(profesor);
}
  
  public void eliminarProfesor(int id){
      profesorRepository.deleteById(id);
  }
}

