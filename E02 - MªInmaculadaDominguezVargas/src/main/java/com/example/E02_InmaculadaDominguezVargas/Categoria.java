package com.example.E02_InmaculadaDominguezVargas;

public class Categoria {

    /* Crea otra entidad, la cual va a relacionar con monumentos con ManyToOne
    *  Crea un repositorio de Categoría y su controlador
    *
    *   Creamos un DTO para Monumento y coge los datos necesarios para instanciar
    *   uno, añadiendo Categoría como Long.
    *
    *   Para poder usar los métodos del Controller, hay que crear una clase para
    *   convertir el CreateMonumentDTO en MonumentoDTO.
    *
    *   public Monumento createMonumentoDTOToMonumento(CreateMonumento c){
    *       return new Monumento(c.blablabla)
    *
    *   }
    *   Se añaden dependencias en el MonumentoControler del converter: CategoriaRepository y
    *   el CreateMonumentoRepository.
    *
    *   Creamos GetDocumentoDTO, que tendrá nombre, ubi, la localización(ciudad, país), y el
    *   categoría.
    *
    *   En converter hacemos un método para obtener un monumentoDTO de un monumento.
    *
    * */
}
