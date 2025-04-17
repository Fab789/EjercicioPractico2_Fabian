

package com.example.cine.Service;

import com.example.cine.domain.Funcion;
import java.util.List;

public interface FuncionService {
    List<Funcion> listar();
    Funcion guardar(Funcion f);
    void eliminar(Long id);
    Funcion obtener(Long id);

}
