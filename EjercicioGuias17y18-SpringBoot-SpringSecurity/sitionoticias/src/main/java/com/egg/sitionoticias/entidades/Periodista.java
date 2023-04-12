package com.egg.sitionoticias.entidades;

import java.util.List;


public class Periodista extends Usuario{
    
    private List<Noticia> misNoticias;
    private Integer sueldoMensual;

    public Periodista() {
    }

    public List<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(List<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }
    
    
}
