/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SLeonProgramacionNCapas.Controller;

import com.digis01.SLeonProgramacionNCapas.JPA.Profesor;
import com.digis01.SLeonProgramacionNCapas.ML.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("profesor")
public class ProfesorController {
    
    
    private final String baseUrl = "http://localhost:8080/api/profesores";

    @GetMapping
    public String index(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Result<List<Profesor>>> responseEntity = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result<List<Profesor>>>() {}
        );

        Result result = responseEntity.getBody();


        if (result != null && result.correct) {
            List<Profesor> profesores = (List<Profesor>)result.object;
            model.addAttribute("profesorBusqueda", new Profesor());
            model.addAttribute("profesores", profesores);
        } else {
            model.addAttribute("profesorBusqueda", new Profesor());
            model.addAttribute("profesores", null);
        }

        return "ProfesorIndex"; 
    }
}
    
    

    
    

