

package com.example.cine.DAO;

import com.example.cine.Domain.pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository<Pelicula, Long> {

}
