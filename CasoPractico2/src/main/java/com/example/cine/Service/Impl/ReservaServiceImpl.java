

package com.example.cine.Service.Impl;

import com.example.cine.Domain.Reserva;
import com.example.cine.DAO.ReservaDao;
import com.example.cine.Service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ReservaServiceImpl implements ReservaService {
    
     @Autowired
    private ReservaDAO reservaDao;

    public List<Reserva> listarPorUsuario(Usuario u) {
        return reservaDao.findByUsuario(u); 
    }
    public Reserva reservar(Reserva r) {
        return reservaDao.save(r); 
    }
    public void cancelar(Long id) {
        reservaDao.deleteById(id); 
    }

}
