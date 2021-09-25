package com.example.E02_InmaculadaDominguezVargas;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository repository;

    @GetMapping("/monumento")
    public List<Monumento> findAll(){
        return repository.findAll();
    }

    @GetMapping("/monumento/{id}")
    public Monumento findById(@PathVariable("id") Long id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/monumento")
    public ResponseEntity<Monumento> add (@RequestBody Monumento monumento){
        return ResponseEntity
                .status(HttpStatus.CREATED) //Le manda el código de respuesta de creado (201)
                .body(repository.save(monumento)); //y guarda el monumento dentro del body.
    }

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/monumento/{id}")
    public Monumento edit (@PathVariable("id") Long id, Monumento monumento){
        Monumento antiguo = repository.findById(id).orElse(monumento);

        antiguo.setNombre_monumento(monumento.getNombre_monumento());
        antiguo.setCodigo_pais(monumento.getCodigo_pais());
        antiguo.setNombre_ciudad(monumento.getNombre_ciudad());
        antiguo.setLocalizacion(monumento.getLocalizacion());
        monumento.setNombre_pais(monumento.getNombre_pais());
        antiguo.setDescripcion(monumento.getDescripcion());
        antiguo.setURL(monumento.getURL());

        return repository.save(antiguo);
    }


}
