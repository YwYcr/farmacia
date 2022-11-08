package com.farmacia.service;



import com.farmacia.dao.CategoriaDao;
import com.farmacia.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CategoriaServiceImp implements CategoriaService {
    //se definen los metodos del CRUD

    //se utiliza una anotacion autowired para que el objeto CategoriaDao
    //si ya esta en memoria se use, si no se crea(singleton)
    @Autowired
    private CategoriaDao categoriaDao;


    //Metodo que retorna la lista de categorias
    @Override
    @Transactional(readOnly=true)
    
    public List<Categoria> getCategorias(boolean activos) {
       var lista = (List<Categoria>)categoriaDao.findAll();
        
      return lista;
    }

    //Dado un categoria.id se busca en la tabla y se retorna todo el objeto (segundo categoria es el objeto)
    //Si el objeto categoria viene vacio entonces Categoria es vacio
    
    @Override
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
        return categoriaDao.findById(categoria.getCategoriaid()).orElse(null);
    }

    //si el categoria .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Categoria categoria){      
        categoriaDao.save(categoria);
    }

    //Elimina el registro
    @Override
    @Transactional
    public void delete(Categoria categoria){
        categoriaDao.delete(categoria);
    }

}
