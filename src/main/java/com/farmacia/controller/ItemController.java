package com.farmacia.controller;

import com.farmacia.dao.CategoriaDao;
import com.farmacia.domain.Categoria;
import com.farmacia.domain.Item;
import com.farmacia.service.CategoriaService;
import com.farmacia.service.ItemService;
import java.util.List;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ItemController {
    
    @Autowired
    private ItemService itemService;
      @Autowired
    private CategoriaService categoriaService;

    @GetMapping({"/","/item/lista"})
    public String inicio(Model model) {

       var items = itemService.getItems();
        model.addAttribute("items", items);
        var categoria = categoriaService.getCategorias(true);
        model.addAttribute("categoria", items);

        return "/item/lista";
    }
    
   @Autowired
   private CategoriaDao categoriadao;
   
   @GetMapping("/item/nuevo")
    public String nuevoItem(Item item, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        return "item/modificar";
    } 
    
    
    
    @PostMapping("/item/guardar")
    public String guardarItem(Item item) {  
         itemService.save(item);
        return "redirect:/item/lista";
    }

    @GetMapping("/item/modificar/{itemid}")
    public String modificarItem(Item item, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);   
     
        item = itemService.getItem(item);
        model.addAttribute("item", item);
        return "item/modificar";
    }
    
    @GetMapping("/item/eliminar/{itemid}")
    public String eliminarItem(Item item) {
        
        itemService.delete(item);
        
        return "redirect:/item/lista";
    }

}
