package com.farmacia.controller;

import com.farmacia.dao.UserDao;
import com.farmacia.domain.Expediente;
import com.farmacia.service.UserService;
import com.farmacia.service.ExpedienteService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ExpedienteController {
    
    @Autowired
    private ExpedienteService expedienteService;
      @Autowired
    private UserService userService;

    @GetMapping("/expediente/lista")
    public String inicio(Model model) {

       var expedientes = expedienteService.getExpedientes();
        model.addAttribute("expedientes", expedientes);
        var user = userService.getUsers();
        model.addAttribute("user", expedientes);

        return "/expediente/lista";
    }
    
   @Autowired
   private UserDao userdao;
   
   @GetMapping("/expediente/nuevo")
    public String nuevoExpediente(Expediente expediente, Model model) {
        var users = userService.getUsers();
        model.addAttribute("users", users);
        
        return "expediente/modificar";
    } 
    
    
    
    @PostMapping("/expediente/guardar")
    public String guardarExpediente(Expediente expediente) {  
         expedienteService.save(expediente);
        return "redirect:/expediente/lista";
    }

    @GetMapping("/expediente/modificar/{expedienteid}")
    public String modificarExpediente(Expediente expediente, Model model) {
        var users = userService.getUsers();
        model.addAttribute("users", users);   
     
        expediente = expedienteService.getExpediente(expediente);
        model.addAttribute("expediente", expediente);
        return "expediente/modificar";
    }
    
    @GetMapping("/expediente/eliminar/{expedienteid}")
    public String eliminarExpediente(Expediente expediente) {
        
        expedienteService.delete(expediente);
        
        return "redirect:/expediente/lista";
    }

}
