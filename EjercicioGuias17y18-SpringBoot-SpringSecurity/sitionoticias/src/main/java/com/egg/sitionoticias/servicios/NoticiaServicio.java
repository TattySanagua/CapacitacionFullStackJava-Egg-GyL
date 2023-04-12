package com.egg.sitionoticias.servicios;

import com.egg.sitionoticias.entidades.Noticia;
import com.egg.sitionoticias.excepciones.Excepcion;
import com.egg.sitionoticias.repositorios.NoticiaRepositorio;
import com.egg.sitionoticias.utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticiaServicio {
 
    @Autowired  //Realiza una inyeccion de dependencias para que el contenedor de Spring sea el encargado de inicializar el objeto y resolver dependencias.
    private NoticiaRepositorio noticiaRepositorio;
    
    @Transactional
    public void crearNoticia(String titulo, String cuerpo) throws Excepcion{
        
        validarDatos(titulo, cuerpo);
        
        Noticia noticia = new Noticia();
        
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setFecha(new Date());
        
        noticiaRepositorio.save(noticia);
    }
    
    @Transactional(readOnly = true) //Transacción de solo lectura
    public List<Noticia> listarTodas(){
        
        List<Noticia> noticias = new ArrayList();
        
        noticias = noticiaRepositorio.findAll();
        
        Collections.sort(noticias, Comparadores.ordenarDesc);
        
        return noticias;
    }
    
    @Transactional
    public void modificarNoticia(String id,String titulo, String cuerpo) throws Excepcion{
       
        validarDatos(titulo, cuerpo);
        
        /* JPA nos provee un Optional que retorna un respuesta de tipo Noticia, 
            Optional es un contenedor que puede contener o no un valor no nulo
            si el valor está presente devuelve True*/
       Optional<Noticia> respuesta = noticiaRepositorio.findById(id);
       
       if(respuesta.isPresent()){
           
           Noticia noticia = respuesta.get();
           
           noticia.setTitulo(titulo);
           noticia.setCuerpo(cuerpo);
           
           noticiaRepositorio.save(noticia);
       }
    }
    
    public Noticia getOne(String id){
        
        return noticiaRepositorio.getOne(id);
    }
    
    public void eliminar(String id){
        
        Noticia noticia = noticiaRepositorio.getById(id);
        
        noticiaRepositorio.delete(noticia);
        
    }
    
    private void validarDatos(String titulo, String cuerpo) throws Excepcion{
        
        if(titulo.isEmpty() || titulo == null){
            throw new Excepcion("El título no puede ser nulo o estar vacío");
        }
        if(cuerpo.isEmpty() || cuerpo == null){
            throw new Excepcion("El cuerpo de la noticia no puede ser nulo o estar vacío");
        }
    }
}
