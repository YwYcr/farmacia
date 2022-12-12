package com.farmacia.service;



import com.farmacia.domain.Carrito;

import static com.farmacia.service.CarritoService.listaCarrito;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;


@Service

public class CarritoServiceImp implements CarritoService {

    @Override
    public List<Carrito> getCarritos() {
        return listaCarrito;
    }

    @Override
    public Carrito getCarrito(Carrito carrito) {
        for (Carrito c : listaCarrito) {
            if (Objects.equals(c.getItemid(), carrito.getItemid())){
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Carrito carrito) {
        boolean existe = false;
        for (Carrito c : listaCarrito){
            if (Objects.equals(c.getItemid(), carrito.getItemid())){
                if(c.getCantidad()< carrito.getCantidadtabla()){
                    c.setCantidad(c.getCantidad()+1);
                }
                existe=true;
                break;
            }
        }
        if(!existe) {carrito.setCantidad(1);
        listaCarrito.add(carrito);
        }    
    }

    @Override
    public void delete(Carrito carrito) {
        var posicion = -1;
        var existe = false;
        for(Carrito c : listaCarrito){
            ++posicion;
            if(Objects.equals(c.getItemid(), carrito.getItemid())){
                existe = true;
                break;
            }
        }
        if (existe) {
            listaCarrito.remove(posicion);
        }
              

    }

    @Override
    public void actualiza(Carrito carrito) {
        for (Carrito i : listaCarrito){
            if(Objects.equals(i.getItemid(), carrito.getItemid())){
                i.setCantidad(carrito.getCantidad());
                break;
            }
        }
    }

    @Override
    public void facturar() {
        for (Carrito i : listaCarrito){
            //Proceso de facturacion
        }
        listaCarrito.clear();
    }
 

}
