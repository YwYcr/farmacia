package com.farmacia.service;


import com.farmacia.dao.CategoriaDao;
import com.farmacia.dao.ItemDao;
import com.farmacia.domain.Categoria;
import com.farmacia.domain.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ItemServiceImp implements ItemService {
    //se definen los metodos del CRUD

    //se utiliza una anotacion autowired para que el objeto ItemDao
    //si ya esta en memoria se use, si no se crea(singleton)
    @Autowired
    private ItemDao itemDao;
     @Autowired
    private CategoriaDao categoriaDao;

    //Metodo que retorna la lista de items
    @Override
    @Transactional(readOnly=true)
    
    public List<Item> getItems() {
        return (List<Item>)itemDao.findAll();
    }

    //Dado un item.id se busca en la tabla y se retorna todo el objeto (segundo item es el objeto)
    //Si el objeto item viene vacio entonces Item es vacio
    
    @Override
    @Transactional(readOnly=true)
    public Item getItem(Item item){
        return itemDao.findById(item.getItemid()).orElse(null);
    }

    //si el item .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Item item){
        Categoria categoria = item.getCategoria();
        categoria=categoriaDao.save(categoria);
        item.setCategoria(categoria);
        
        itemDao.save(item);
    }

    //Elimina el registro
    @Override
    @Transactional
    public void delete(Item item){
        itemDao.delete(item);
    }

}
