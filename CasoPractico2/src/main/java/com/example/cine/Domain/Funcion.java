
package com.example.cine.Domain;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="funcion")
public class Funcion {
    
    @Id
    @GeneratedValue
    
    private Long id;
    
    private int id_pelicula;
    private String fecha;
    private String hora;
    private String sala;
    

}
