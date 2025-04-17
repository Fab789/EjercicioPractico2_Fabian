

package com.example.cine.Service;

import com.example.cine.domain
import java.util.List;

public interface ReservaService {
    
    List<Reserva> listarPorUsuario(Usuario usuario);
    Reserva reservar(Reserva r);
    void cancelar(Long id);
}

}
