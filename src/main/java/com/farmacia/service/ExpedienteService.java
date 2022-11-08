
package com.farmacia.service;


import com.farmacia.domain.Expediente;
import java.util.List;

public interface ExpedienteService {

    public List<Expediente> getExpedientes();
    

    public Expediente getExpediente(Expediente expediente);

    public void save(Expediente expediente);
    
    
    //Elimina el registro
    public void delete(Expediente expediente);
    
    
}
