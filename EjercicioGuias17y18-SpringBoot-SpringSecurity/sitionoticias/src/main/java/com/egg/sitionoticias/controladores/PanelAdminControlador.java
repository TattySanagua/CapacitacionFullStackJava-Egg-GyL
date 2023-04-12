package com.egg.sitionoticias.controladores;

import com.egg.sitionoticias.entidades.Noticia;
import com.egg.sitionoticias.excepciones.Excepcion;
import com.egg.sitionoticias.servicios.NoticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class PanelAdminControlador {
    
    @Autowired
    private NoticiaServicio noticiaServicio;
    
    
    @GetMapping("/dashboard")
    public String panelAdministrativo(ModelMap modelo){
        
        List<Noticia> noticias = noticiaServicio.listarTodas();
        
        modelo.addAttribute("noticias", noticias);
        
        return "admin.html";
    }
    
    @GetMapping("/registrar")
    public String admin(){
        return "panelAdmin.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) String titulo, 
            @RequestParam(required = false) String cuerpo, ModelMap modelo){
       
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            
            modelo.put("exito", "La noticia fue creada correctamente");
            
        } catch (Excepcion ex) {

            modelo.put("error", ex.getMessage());
            
            return "panelAdmin.html";
        }
        return "panelAdmin.html";
    }
    
   
}
