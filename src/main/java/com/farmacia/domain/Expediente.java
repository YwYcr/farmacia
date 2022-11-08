package com.farmacia.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="expediente")

public class Expediente implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="expedienteid")
    private Long expedienteid;
    
    private String cedula;
    private String contacto; 
    private String descripcion; 
    private Date fecha; 
    private boolean activo;
    
    
    @JoinColumn(name="userid", referencedColumnName="userid")
    @ManyToOne(fetch =FetchType.EAGER)
    private User user;

    public Expediente() {
    }

    public Expediente(String cedula, String contacto, String descripcion, Date fecha, boolean activo, User user) {
        this.cedula = cedula;
        this.contacto = contacto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.activo = activo;
        this.user = user;
    }

    public Expediente(String cedula, String contacto, String descripcion, Date fecha, boolean activo) {
        this.cedula = cedula;
        this.contacto = contacto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.activo = activo;
    }

    public Expediente(Long expedienteid, String cedula, String contacto, String descripcion, Date fecha, boolean activo, User user) {
        this.expedienteid = expedienteid;
        this.cedula = cedula;
        this.contacto = contacto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.activo = activo;
        this.user = user;
    }



  

 


    
    
}
