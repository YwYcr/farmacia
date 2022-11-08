package com.farmacia.service;



import com.farmacia.dao.UserDao;
import com.farmacia.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class UserServiceImp implements UserService {
    //se definen los metodos del CRUD

    //se utiliza una anotacion autowired para que el objeto UserDao
    //si ya esta en memoria se use, si no se crea(singleton)
    @Autowired
    private UserDao userDao;


    //Metodo que retorna la lista de users
    @Override
    @Transactional(readOnly=true)
    
    public List<User> getUsers() {
       var lista = (List<User>)userDao.findAll();
        
      return lista;
    }

    //Dado un user.id se busca en la tabla y se retorna todo el objeto (segundo user es el objeto)
    //Si el objeto user viene vacio entonces User es vacio
    
    @Override
    @Transactional(readOnly=true)
    public User getUser(User user){
        return userDao.findById(user.getUserid()).orElse(null);
    }

    //si el user .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(User user){      
        userDao.save(user);
    }

    //Elimina el registro
    @Override
    @Transactional
    public void delete(User user){
        userDao.delete(user);
    }

}
