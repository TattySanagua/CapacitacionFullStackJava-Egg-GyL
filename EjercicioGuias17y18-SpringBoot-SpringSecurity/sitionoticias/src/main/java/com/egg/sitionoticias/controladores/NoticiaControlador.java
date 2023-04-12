package com.egg.sitionoticias.controladores;

import com.egg.sitionoticias.excepciones.Excepcion;
import com.egg.sitionoticias.servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {
    
    @Autowired
    private NoticiaServicio noticiaServicio;
    
    @GetMapping("/{id}")
    public String verNoticia(@PathVariable String id, ModelMap modelo){
        
        modelo.put("noticia", noticiaServicio.getOne(id));
        
        return "noticia.html";
    }
    
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo){
        
        modelo.put("noticia", noticiaServicio.getOne(id));
        
        return "noticia_modificar.html";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String titulo, String cuerpo, ModelMap modelo){
        
        try {
            noticiaServicio.modificarNoticia(id, titulo, cuerpo);
            
            return "redirect:../"+id;
            
        } catch (Excepcion ex) {
            
            modelo.put("error", ex.getMessage());
            
            return "noticia_modificar.html";
        }
    }
}
