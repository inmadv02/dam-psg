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
                Arrays.asList(new Monumento(456, "España",
                                "Sevilla", "La Giralda"),
                              new Monumento(327, "Francia",
                                "París", "La Torre Eiffel"),
                              new Monumento(123, "Brasil",
                                      "Río de Janeiro", "Cristo Redentor")));
    }
}
