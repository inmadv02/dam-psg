package com.salesianostriana.dam.dto.dto;

import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
/* En lugar de tener que instaciar un objeto y complicarnos la vida si tiene muchos campos,
*  invocamos de manera encadenada a una serie de métodos (constructor vacío, getters y setters)
*  que nos facilite la construcción del objeto.
*/
public class GetMonumentoDto { /* Los DTOS nos permiten guardar los datos en la base de datos de una manera
                                y presentarlos de otra forma. */

    private String nombre;
    private String loc;
    private String ubicacion;
    private String categoria;

}
