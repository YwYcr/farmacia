package com.farmacia.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="items")

public class Item implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="itemid")
    private Long itemid;
    private Long categoriaid;
    private String nombre;   
    private Double precio;
    private int cantidad;
    
    

    public Item() {
    }

    public Item(Long categoriaid, String nombre, Double precio, int cantidad) {
        this.categoriaid = categoriaid;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

 


    
    
}
