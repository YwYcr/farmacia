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
    
    private String nombre;   
    private Double precio;
    private int cantidad;
    
    @JoinColumn(name="categoriaid", referencedColumnName="categoriaid")
    @ManyToOne(fetch =FetchType.EAGER)
    private Categoria categoria;

    public Item() {
    }

    public Item(String nombre, Double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    

    public Item(String nombre, Double precio, int cantidad, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

  

 


    
    
}
