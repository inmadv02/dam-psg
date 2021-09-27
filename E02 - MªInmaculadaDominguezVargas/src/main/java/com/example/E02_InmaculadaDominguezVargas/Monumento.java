package com.example.E02_InmaculadaDominguezVargas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
<<<<<<< HEAD
@Data //Creaba los getters, los setter, etc.
@NoArgsConstructor
@AllArgsConstructor
=======
@Data
@AllArgsConstructor
@NoArgsConstructor
>>>>>>> 84330997c86e0eb3ad754d5bbabcfc76490a491a
@Table(name = "monumento")
public class Monumento {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

<<<<<<< HEAD
    private String codigo_pais;
=======
    private int codigo_pais;
>>>>>>> 84330997c86e0eb3ad754d5bbabcfc76490a491a
    private String nombre_pais;
    private String nombre_ciudad;

    @OneToOne(mappedBy = "monumento")
    private Localizacion localizacion;

    private String nombre_monumento;
    private String descripcion;
<<<<<<< HEAD
    private String url;

    public Monumento(String codigo_pais, String nombre_pais, String nombre_ciudad, String nombre_monumento) {
=======
    private String URL;

    public Monumento(int codigo_pais, String nombre_pais, String nombre_ciudad, String nombre_monumento) {
>>>>>>> 84330997c86e0eb3ad754d5bbabcfc76490a491a
        this.codigo_pais = codigo_pais;
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.nombre_monumento = nombre_monumento;
    }
}
