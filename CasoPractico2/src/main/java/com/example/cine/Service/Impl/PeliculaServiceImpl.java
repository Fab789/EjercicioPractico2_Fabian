

package com.example.cine.Service.Impl;


import com.example.cine.Domain.Pelicula;
import com.example.cine.DAO.PeliculaDao;
import com.example.cine.Service.PeliculaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    
     @Autowired
    private PeliculaDAO peliculaDao;

    public List<Pelicula> listar() {
        return peliculaDao.findAll(); 
    }
    public Pelicula guardar(Pelicula p) {
        return peliculaDao.save(p); 
    }
    public void eliminar(Long id) {
        dao.deleteById(id); 
    }
    public Pelicula obtener(Long id) {
        return dao.findById(id).orElse(null); 
    }

}
