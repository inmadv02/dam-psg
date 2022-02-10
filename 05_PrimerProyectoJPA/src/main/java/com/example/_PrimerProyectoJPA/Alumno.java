package com.example._PrimerProyectoJPA;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
//A partir de ahora no la usaremos tanto
//Para evitar errores con el proxy, poner lo de Serializable.
// Ponerlo siempre por si acaso
public class Alumno implements Serializable {

    @Id
    @GeneratedValue //Se puede tunear con las indicaciones de los apuntes de Luismi
    private Long id;

    private String nombre, apellidos, email;
}
