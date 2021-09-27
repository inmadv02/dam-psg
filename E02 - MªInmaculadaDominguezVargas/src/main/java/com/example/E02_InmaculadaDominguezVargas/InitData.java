package com.example.E02_InmaculadaDominguezVargas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final MonumentoRepository repository;

    @PostConstruct
    public void initData(){

        repository.saveAll(
<<<<<<< HEAD
                Arrays.asList(new Monumento("ES", "España",
                                "Sevilla", "La Giralda"),
                              new Monumento("FR", "Francia",
                                "París", "La Torre Eiffel"),
                              new Monumento("BR", "Brasil",
=======
                Arrays.asList(new Monumento(456, "España",
                                "Sevilla", "La Giralda"),
                              new Monumento(327, "Francia",
                                "París", "La Torre Eiffel"),
                              new Monumento(123, "Brasil",
>>>>>>> 84330997c86e0eb3ad754d5bbabcfc76490a491a
                                      "Río de Janeiro", "Cristo Redentor")));
    }
}
