package com.farmacia.controller;

import com.farmacia.domain.Carrito;
import com.farmacia.domain.Item;
import com.farmacia.service.CarritoService;
import com.farmacia.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j

public class CarritoController {
    
    @Autowired
    private CarritoService carritoService;
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/carrito/lista")
    public String inicio(Model model) {

       var carritos = carritoService.getCarritos();
        model.addAttribute("carritos", carritos);
        var carritoTotalVenta=0;
        for(Carrito i : carritos){
            carritoTotalVenta += (i.getCantidad()*i.getPrecio());
            
        }
        model.addAttribute("carritoTotal",carritoTotalVenta);
        

        return "/carrito/lista";
    }
    
    @GetMapping("/carrito/agregar/{itemid}")
    public ModelAndView agregarCarrito (Model model, Carrito carrito){
        Carrito carrito2 = carritoService.getCarrito(carrito);
        if(carrito2==null){
            Item item = itemService.getItem(carrito);
            carrito2=new Carrito(item);
            
        }
        carritoService.save(carrito2);
        var lista=carritoService.getCarritos();
        var totalCarritos=0;
        var carritoTotalVenta=0;
        for(Carrito i : lista) {
            totalCarritos+=i.getCantidad();
            carritoTotalVenta += (i.getCantidad()*i.getPrecio());
        }
        model.addAttribute("listaCarrito", lista);
        model.addAttribute("listaTotal",totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }
    
    @GetMapping("/carrito/modificar/{itemid}")
    public String modificarCarrito(Carrito carrito, Model model){
        carrito=carritoService.getCarrito(carrito);
        model.addAttribute("carrito",carrito);
        return "/carrito/modificar";
    }
    
        @GetMapping("/carrito/eliminar/{itemid}")
    public String eliminarCarrito(Carrito carrito){
        carritoService.delete(carrito);
        
        return "redirect:/carrito/lista";
    }
    
    @PostMapping("/carrito/guardar")
    public String guardarCarrito(Carrito carrito){
        carritoService.actualiza(carrito);
        return "redirect:/carrito/lista";
    }
    
        @GetMapping("/facturar/carrito")
    public String facturarCarrito(){
        carritoService.facturar();
        return "redirect:/";
    }
    
}