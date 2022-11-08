

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
@Table(name="user")

public class User implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long userid;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    
    

    public User() {
    }

    public User(String nombre, String apellidos, String correo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }

  
    
}
