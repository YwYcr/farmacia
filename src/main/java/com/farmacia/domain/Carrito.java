
package com.farmacia.domain;

import lombok.Data;

@Data
public class Carrito extends Item{
    private int cantidad;

    public Carrito() {
    }

    public Carrito(Item item) {
        super.setItemid(item.getItemid());
        super.setNombre(item.getNombre());
        super.setCategoria(item.getCategoria());
        super.setPrecio(item.getPrecio());
        super.setCantidadtabla(item.getCantidadtabla());
        this.cantidad = 0;
    }

    
    
}
