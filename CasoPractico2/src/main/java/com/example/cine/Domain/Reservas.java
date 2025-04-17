

package com.example.cine.Domain;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="reservas")
public class Reservas {
    
    @Id
    @GeneratedValue
    
     private Long id;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Funcion funcion;

    private int cantidad;

}
