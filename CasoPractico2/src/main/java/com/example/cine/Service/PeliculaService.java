

package com.example.cine.Service;

import com.example.cine.domain.Pelicula;
import java.util.List;

public interface PeliculaService {
List<Pelicula> listar();
    Pelicula guardar(Pelicula p);
    void eliminar(Long id);
    Pelicula obtener(Long id);
}

