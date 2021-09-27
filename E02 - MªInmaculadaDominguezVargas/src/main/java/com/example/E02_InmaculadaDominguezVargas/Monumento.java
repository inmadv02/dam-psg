package com.example.E02_InmaculadaDominguezVargas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
@Data //Creaba los getters, los setter, etc.
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "monumento")
public class Monumento {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String codigo_pais;
    private String nombre_pais;
    private String nombre_ciudad;

    @OneToOne(mappedBy = "monumento")
    private Localizacion localizacion;

    private String nombre_monumento;
    private String descripcion;
    private String url;

    public Monumento(String codigo_pais, String nombre_pais, String nombre_ciudad, String nombre_monumento) {
        this.codigo_pais = codigo_pais;
        this.nombre_pais = nombre_pais;
        this.nombre_ciudad = nombre_ciudad;
        this.nombre_monumento = nombre_monumento;
    }
}
