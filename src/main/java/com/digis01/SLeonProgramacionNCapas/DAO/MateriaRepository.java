/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.DAO;


import com.digis01.SLeonProgramacionNCapas.JPA.Materia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    List<Materia> findByNombre(String nombre);
}
