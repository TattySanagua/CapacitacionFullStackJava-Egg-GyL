package com.egg.sitionoticias.utilidades;

import com.egg.sitionoticias.entidades.Noticia;
import java.util.Comparator;


public class Comparadores {
    
    public static Comparator<Noticia> ordenarDesc = new Comparator<Noticia>() {
        @Override
        public int compare(Noticia n1, Noticia n2) {
            return n2.getFecha().compareTo(n1.getFecha());
        }
    };
}
