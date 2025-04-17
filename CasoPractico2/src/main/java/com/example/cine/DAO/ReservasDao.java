

package com.example.cine.DAO;

import com.example.cine.Domain.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasDao extends JpaRepository<Reservas, Long {
     List<Reserva> findByUsuario(Usuario usuario);

}
