package com.egg.sitionoticias.servicios;

import com.egg.sitionoticias.entidades.Imagen;
import com.egg.sitionoticias.excepciones.Excepcion;
import com.egg.sitionoticias.repositorios.ImagenRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServicio {
    
    @Autowired
    private ImagenRepositorio imagenRepositorio;
    
    public Imagen crearYGuardar(MultipartFile archivo) throws Excepcion{
        
        if(archivo != null){
            
            try {
                
                Imagen imagen = new Imagen();
                
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                
                return imagenRepositorio.save(imagen);
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        
        return null;
    }
    
    public Imagen actualizar(MultipartFile archivo, String idImagen) throws Excepcion{
        
        if(archivo != null){
            
            try {
                
                Imagen imagen = new Imagen();
                
                if(idImagen != null){
                    
                    Optional<Imagen> respuesta = imagenRepositorio.findById(idImagen);
                    
                    if(respuesta.isPresent()){
                        
                        imagen = respuesta.get();
                    }
                }
                
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                
                return imagenRepositorio.save(imagen);
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        
        return null;
        
    }
}
