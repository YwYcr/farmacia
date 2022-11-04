
package com.farmacia.service;


import com.farmacia.domain.Item;
import java.util.List;

public interface ItemService {

    public List<Item> getItems();
    

    public Item getItem(Item item);

    public void save(Item item);
    
    
    //Elimina el registro
    public void delete(Item item);
    
    
}
