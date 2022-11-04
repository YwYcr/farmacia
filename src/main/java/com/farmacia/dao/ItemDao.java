
package com.farmacia.dao;


import com.farmacia.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long>{
    
    
}
