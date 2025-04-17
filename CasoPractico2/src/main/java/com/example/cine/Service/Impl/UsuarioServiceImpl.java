

package com.example.cine.Service.Impl;

import com.example.cine.Domain.Usuario;
import com.example.cine.DAO.UsuarioDao;
import com.example.cine.Service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
     @Autowired
     private UsuarioDAO usuarioDao;
     
      public List<Reserva> listarPorUsuario(Usuario u) { return usuarioDao.findByUsuario(u); }
    public Reserva reservar(Reserva r) { return usuarioDao.save(r); }
    public void cancelar(Long id) { usuarioDao.deleteById(id); }

}
