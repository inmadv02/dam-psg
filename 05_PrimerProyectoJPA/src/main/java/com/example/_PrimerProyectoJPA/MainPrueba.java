package com.example._PrimerProyectoJPA;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final AlumnoRepository repository;

    @PostConstruct
    public void test(){

        Alumno a = Alumno.builder()
                .apellidos("Luismi")
                .nombre("Luismi")
                .email("Luismi")
                .build();

        repository.save(a);

        repository.findAll().forEach(System.out::println);
    }
}
