
package com.example.cine.DAO;

import com.example.cine.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String usuario);

}
