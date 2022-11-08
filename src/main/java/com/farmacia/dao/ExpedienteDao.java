
package com.farmacia.dao;


import com.farmacia.domain.Expediente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteDao extends JpaRepository<Expediente, Long>{
    
    
}
