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
                Arrays.asList(new Monumento("ES", "España",
                                "Sevilla", "La Giralda"),
                              new Monumento("FR", "Francia",
                                "París", "La Torre Eiffel"),
                              new Monumento("BR", "Brasil",
                                      "Río de Janeiro", "Cristo Redentor")));
    }
}
