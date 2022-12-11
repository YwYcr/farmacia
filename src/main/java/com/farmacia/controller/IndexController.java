package com.farmacia.controller;

import com.farmacia.service.CategoriaService;
import com.farmacia.service.ItemService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {
    
        @Autowired
    private ItemService itemService;
      @Autowired
    private CategoriaService categoriaService;
    
 @GetMapping("/")
    public String inicio(Model model) {

       var items = itemService.getItems();
        model.addAttribute("items", items);
        var categoria = categoriaService.getCategorias(true);
        model.addAttribute("categoria", items);

        return "index";
    }

}
