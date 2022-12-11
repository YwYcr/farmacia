
package com.farmacia.service;


import com.farmacia.domain.Carrito;
import java.util.ArrayList;
import java.util.List;

public interface CarritoService {
    
    public List<Carrito> listaCarrito= new ArrayList<>();

    public List<Carrito> getCarritos();
    

    public Carrito getCarrito(Carrito carrito);

    public void save(Carrito carrito);
    

    public void delete(Carrito carrito);
    
    
    public void actualiza (Carrito carrito);
    
    public void facturar();
    
    
    
    
    
}
