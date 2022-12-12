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
    private int cantidadtabla;
    
    @JoinColumn(name="categoriaid", referencedColumnName="categoriaid")
    @ManyToOne(fetch =FetchType.EAGER)
    private Categoria categoria;
    @Column(name="rutaimagen")
    private String rutaimagen;

    public Item() {
    }

    public Item(String nombre, Double precio, int cantidadtabla) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadtabla = cantidadtabla;
    }
    
    

    public Item(String nombre, Double precio, int cantidadtabla, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadtabla = cantidadtabla;
        this.categoria = categoria;
    }

  

 


    
    
}
