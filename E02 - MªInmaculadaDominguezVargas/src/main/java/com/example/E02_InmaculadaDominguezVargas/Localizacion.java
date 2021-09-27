package com.example.E02_InmaculadaDominguezVargas;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "localizacion")
public class Localizacion {

    @Id
    @GeneratedValue
    @Column(name = "id_localizacion")
    private Long id_localizacion;

    private Double latitud;
    private Double longitud;

    @OneToOne
    @JoinColumn(name = "id_localizacion", referencedColumnName = "id")
    private Monumento monumento;


}
