

package com.example.cine.Domain;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="pelicula")
public class Pelicula {
    @Id
    @GeneratedValue
     private Long id;
    private String titulo;
    private String tipo;
   

}
