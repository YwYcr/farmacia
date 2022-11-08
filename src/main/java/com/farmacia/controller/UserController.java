package com.farmacia.controller;

import com.farmacia.domain.User;
import com.farmacia.service.UserService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/lista")
    public String inicio(Model model) {

       var users = userService.getUsers();
        model.addAttribute("users", users);
        

        return "/user/lista";
    }
    
 

 
   @GetMapping("/user/nuevo")
    public String nuevoUser(User user, Model model) {
                var users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/modificar";
    }  
    
    
    @PostMapping("/user/guardar")
    public String guardarUser(User user) {  
         userService.save(user);
        return "redirect:/user/lista";
    }

    @GetMapping("/user/modificar/{userid}")
    public String modificarUser(User user, Model model) {  
        user = userService.getUser(user);
        model.addAttribute("user", user);
        return "user/modificar";
    }
    
    @GetMapping("/user/eliminar/{userid}")
    public String eliminarUser(User user) {
        
        userService.delete(user);
        
        return "redirect:/user/lista";
    }

}
