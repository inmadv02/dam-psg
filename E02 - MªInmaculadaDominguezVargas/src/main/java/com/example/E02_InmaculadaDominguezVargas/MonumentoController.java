package com.example.E02_InmaculadaDominguezVargas;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* Utilizamos la anotación:
*       1. @RestController para hacer un controlador REST
*       2. @RequiredArgsConstructor para la inyección de dependencias entre el Controller y el Repositorio
*/
@RestController
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository repository;

    /*
    * Usamos @GetMapping porque estamos solicitando una consulta de todos los monumentos.
    * Devolvemos una lista con todos estos monumentos llamando al método "findAll()" que
    * tenemos en el repositorio MonumentoRepository.
    *
    * */
    @GetMapping("/monumento")
    public List<Monumento> findAll(){
        return repository.findAll();
    }

    /*
    * Al igual que en el método anterior, usamos el método GET porque se trata de una consulta.
    * En este caso, queremos obtener solo un monumento, por lo que con @Path Variable le pasamos
    * la id del recurso en concreto al método findById.
    * Asimismo, utilizamos ResponseEntity, una clase que devuelve el código de estado propio de HTTP.
    * Con ok() le hemos especificado que nos devuelva un código 200 para indicar que la búsqueda se
    * ha realizado correctamente.
    * En el caso de que no encuentre nada, devolverá null
    * */
    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(repository.findById(id).orElse(null));
    }

    /*
    * Se usa el método POST, ya que queremos insertar un nuevo recurso.
    * Volvemos a emplear ResponseEntity debido a que sin esta clase, el servidor nos devolvería un código 200
    * y no se crearía el nuevo monumento. De esta forma, nos aseguramos de obtener un código 201.
    * Aparece una nueva anotación: @RequestBody, que guardará dentro del cuerpo de la petición el objeto
    * monumento.
     */
    @PostMapping("/monumento")
    public ResponseEntity<Monumento> add (@RequestBody Monumento monumento){
        return ResponseEntity
                .status(HttpStatus.CREATED) //Con .status(), se le manda el código de respuesta de creado (201)
                .body(repository.save(monumento)); //Se guarda el monumento dentro del body.
    }

    /*
    * Eliminamos un elemento buscándolo primero por su id y revolvemos
    * un mensaje vacío con ResponseEntity.noContent()
    */
    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<Monumento> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    * Con el método put, actualizamos los datos del monumento que elijamos.
    * En este caso hemos decidido settear los valores nuevos del objeto usando
    * un Optional con el método of() para crear un ResponseEntity que nos devuelva
    * el código de respuesta 201.
    * m sería el monumento desactualizado y monumento el actualizado.
    * Este método se podría haber realizado sin el optional, setteando los valores
    * la misma forma tras crear una variable de tipo Monumento, que sería el monumento
    * más "antiguo"
    *
    * Dentro del map, guardamos en la base de datos el objeto actualizado y lo devolvemos.
    * */

    @PutMapping("/monumento/{id}")
    public ResponseEntity<Monumento> edit (@PathVariable Long id, @RequestBody Monumento monumento){
        return ResponseEntity
                .of(repository.findById(id)
                        .map(m ->
                            {
                                m.setNombre_monumento(monumento.getNombre_monumento());
                                m.setCodigo_pais(monumento.getCodigo_pais());
                                m.setNombre_ciudad(monumento.getNombre_ciudad());
                                m.setLocalizacion(monumento.getLocalizacion());
                                m.setNombre_pais(monumento.getNombre_pais());
                                m.setDescripcion(monumento.getDescripcion());
                                m.setUrl(monumento.getUrl());
                                repository.save(m);
                                return m;

                            } ));

    }


}
