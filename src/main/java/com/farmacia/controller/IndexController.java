package com.farmacia.controller;

import com.farmacia.service.ItemService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String inicio(Model model) {

       var items = itemService.getItems();
        model.addAttribute("items", items);

        return "index";
    }

}
