package com.egg.sitionoticias.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Noticia {
    
    @Id
    @GeneratedValue(generator = "uuid")  //El id se autogenera cuando la entidad persiste en la base de datos, es una cadena de texto alfanumérica única
    @GenericGenerator(name = "uuid", strategy = "uuid2")  //ALternativa 2 para asegurarnos de que no se repitan los id en la BD
    private String id;
    private String titulo;
    private String cuerpo;
    
//    @ManyToOne
//    private Periodista creador;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Noticia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    
    
}
