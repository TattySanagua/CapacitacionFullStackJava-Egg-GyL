package com.egg.sitionoticias.controladores;

import com.egg.sitionoticias.entidades.Noticia;
import com.egg.sitionoticias.entidades.Usuario;
import com.egg.sitionoticias.excepciones.Excepcion;
import com.egg.sitionoticias.servicios.NoticiaServicio;
import com.egg.sitionoticias.servicios.UsuarioServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/") // localhost:8080/  Configura cual es la Url que va a escuchar este controlador, en este caso el controlador va a escuchar a partir de la barra "/"
public class PortalControlador {
    
    @Autowired
    private NoticiaServicio noticiaServicio;
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/") // localhost:8080/  Cuando se ingrese a la url la Barra "/" va a ejecutar el cuerpo del metodo index
    public String index(ModelMap modelo){
        
        List<Noticia> noticias = noticiaServicio.listarTodas();
        
        modelo.addAttribute("noticias", noticias);
        
        return "index.html"; // El metodo index devuelve la vista del index 
        
    }
    
    @GetMapping("/registrar")
    public String registrar(){
        return "registro.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre,@RequestParam String email,
            @RequestParam String password, @RequestParam String password2, ModelMap modelo,
            MultipartFile archivo){
       
        try {
            usuarioServicio.registrar(nombre, email, password, password2,archivo);
            
            modelo.put("exito", "Usuario registrado correctamente");
            
            return "index.html";
            
        } catch (Excepcion ex) {
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);

            return "registro.html";
        }
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo){
        
        if(error != null){
            
            modelo.put("error", "Usuario o contraseña incorrectos");
        }
        return"login.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMINISTRADOR')")
    @GetMapping("/inicio")
    public String inicio(ModelMap modelo, HttpSession session){
        
        List<Noticia> noticias = noticiaServicio.listarTodas();
        
        modelo.addAttribute("noticias", noticias);
        
        Usuario logeado = (Usuario) session.getAttribute("usuariosession");
        
        if(logeado.getRol().toString().equals("ADMINISTRADOR")){
            
            return "redirect:/admin/dashboard";
        }
        
        return "inicio.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMINISTRADOR')")
    @GetMapping("/perfil")
    public String perfil(ModelMap modelo,HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
         modelo.put("usuario", usuario);
        return "registro_modificar.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMINISTRADOR')")
    @PostMapping("/perfil/{id}")
    public String actualizar(@PathVariable String id, @RequestParam String nombre,@RequestParam String email,
            @RequestParam String password, @RequestParam String password2, ModelMap modelo,
            MultipartFile archivo){
        
        try {
            usuarioServicio.actualizar(id, nombre, email, password, password2, archivo);
            
            modelo.put("exito", "Usuario modificado correctamente");
            
            return "redirect:/inicio";
            
        } catch (Excepcion ex) {
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);

            return "registro_modificar.html";
        }
    }
}
