
package com.farmacia.dao;


import com.farmacia.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
    
}
