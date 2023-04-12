package com.egg.sitionoticias.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Imagen {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String mime;
    
    private String nombre;
    
    @Lob @Basic(fetch = FetchType.LAZY) //Como el contenido puede ser muy pesado (Lob), solo se cargará cuando se haga un Get de este atributo. El tipo de carga va a ser perezosa o Lazy
    private byte[] contenido;
    
    /* Cuando se cargue un objeto imagen se van a cargar todos los atributos de la imagen que tiene 
        por defecto un fetch EAGER (id, mime, nombre) excepto el contenido que se va a cargar solo
        cuando sea requerido con un get, sino la carga no se hace.
    */

    public Imagen() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
    
    
}
