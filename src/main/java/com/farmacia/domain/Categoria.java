

package com.farmacia.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name="categoria")

public class Categoria implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long categoriaid;
    private String nombre;
    private boolean activo;
    

    public Categoria() {
    }

 
    
    public Categoria(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    /**
     * @return the categoriaid
     */
    public Long getCategoriaid() {
        return categoriaid;
    }

    /**
     * @param categoriaid the categoriaid to set
     */
    public void setCategoriaid(Long categoriaid) {
        this.categoriaid = categoriaid;
    }

   


    
    
}
