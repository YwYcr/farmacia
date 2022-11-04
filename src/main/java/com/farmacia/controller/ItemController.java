package com.farmacia.controller;

import com.farmacia.domain.Item;
import com.farmacia.service.ItemService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String inicio(Model model) {

       var items = itemService.getItems();
        model.addAttribute("items", items);

        return "/item/index";
    }
    
   @GetMapping("/item/nuevo")
    public String nuevoItem(Item item) {
        return "item/modificar";
    } 
    
    
    @PostMapping("/item/guardar")
    public String guardarItem(Item item) {
        itemService.save(item);
        return "redirect:/item/index";
    }

    @GetMapping("/item/modificar/{itemid}")
    public String modificarItem(Item item, Model model) {
        
        item = itemService.getItem(item);
        model.addAttribute("item", item);
        return "item/modificar";
    }
    
    @GetMapping("/item/eliminar/{itemid}")
    public String eliminarItem(Item item) {
        
        itemService.delete(item);
        
        return "redirect:/item/index";
    }

}
