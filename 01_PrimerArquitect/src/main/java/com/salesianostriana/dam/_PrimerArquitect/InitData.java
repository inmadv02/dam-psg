package com.salesianostriana.dam._PrimerArquitect;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final TaskRepository repository;

    @PostConstruct
    public void init(){

        repository.saveAll(
                Arrays.asList(new Task("Rellenenar initdata", "Lo que sea"),
                        new Task("jhgfd", "dgbfgbcnj"),
                        new Task("edthtghsej", "fyhhjymbfk")));


    }
}
