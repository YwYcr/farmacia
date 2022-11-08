package com.farmacia.service;


import com.farmacia.dao.ExpedienteDao;
import com.farmacia.dao.UserDao;
import com.farmacia.domain.Expediente;
import com.farmacia.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ExpedienteServiceImp implements ExpedienteService {
    //se definen los metodos del CRUD

    //se utiliza una anotacion autowired para que el objeto ExpedienteDao
    //si ya esta en memoria se use, si no se crea(singleton)
    @Autowired
    private ExpedienteDao expedienteDao;
     @Autowired
    private UserDao userdao;

    //Metodo que retorna la lista de expedientes
    @Override
    @Transactional(readOnly=true)
    
    public List<Expediente> getExpedientes() {
        return (List<Expediente>)expedienteDao.findAll();
    }

    //Dado un expediente.id se busca en la tabla y se retorna todo el objeto (segundo expediente es el objeto)
    //Si el objeto expediente viene vacio entonces Expediente es vacio
    
    @Override
    @Transactional(readOnly=true)
    public Expediente getExpediente(Expediente expediente){
        return expedienteDao.findById(expediente.getExpedienteid()).orElse(null);
    }

    //si el expediente .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Expediente expediente){
        User user = expediente.getUser();
        user.setUserid(user.getUserid());
      expedienteDao.save(expediente);
    }

    //Elimina el registro
    @Override
    @Transactional
    public void delete(Expediente expediente){
        expedienteDao.delete(expediente);
    }

}
