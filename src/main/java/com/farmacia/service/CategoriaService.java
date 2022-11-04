
package com.farmacia.service;


import com.farmacia.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);
    

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);
    
    
    //Elimina el registro
    public void delete(Categoria categoria);
    
    
}
