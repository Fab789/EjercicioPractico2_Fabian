

package com.example.cine.Service.Impl;

import com.example.cine.Domain.Funcion;
import com.example.cine.DAO.FuncionDao;
import com.example.cine.Service.FuncionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionServiceImpl implements FuncionService {
    
    
    public List<Funcion> listar() {
        return dao.findAll()
    }
       public Funcion guardar(Funcion f) {
           return dao.save(f); 
       }
    public void eliminar(Long id) {
    dao.deleteById(id); 
    }
    public Funcion obtener(Long id) {
        return dao.findById(id).orElse(null); 
    }

}
