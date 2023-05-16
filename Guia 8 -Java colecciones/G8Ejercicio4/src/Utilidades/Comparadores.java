package Utilidades;

import Entidades.Pelicula;
import java.util.Comparator;

public class Comparadores {
    
    public static Comparator<Pelicula> ordenarDuracionDesc = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
           return p2.getDuracion().compareTo(p1.getDuracion());
        }
    };
    
    public static Comparator<Pelicula> ordenarDuracionAsc = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
           return p1.getDuracion().compareTo(p2.getDuracion());
        }
    };
    
    public static Comparator<Pelicula> ordenarTituloAsc = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
           return p1.getTitulo().compareTo(p2.getTitulo());
        }
    };
    
    //Utilizando expresion lambda
    public static Comparator<Pelicula> ordenarDirectorAsc = (Pelicula p1, Pelicula p2) -> p1.getDirector().compareTo(p2.getDirector());
}
