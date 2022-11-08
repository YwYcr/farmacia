
package com.farmacia.service;


import com.farmacia.domain.User;
import java.util.List;

public interface UserService {

    public List<User> getUsers();
    

    public User getUser(User user);

    public void save(User user);
    
    
    //Elimina el registro
    public void delete(User user);
    
    
}
