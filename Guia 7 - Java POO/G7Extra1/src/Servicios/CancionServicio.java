package Servicios;

import Entidades.Cancion;
import java.util.Scanner;

public class CancionServicio {
    
    Scanner leer = new Scanner(System.in);
    
    public Cancion crearCancion(){
        
        Cancion c = new Cancion();
        
        System.out.println("Ingrese titulo de la cancion");
        c.setTitulo(leer.next());
        
        System.out.println("Ingrese el autor de la cancion");
        c.setAutor(leer.next());
        
        return c;
    }
    
    public void mostrarCancion(Cancion c){
        
        System.out.println("Título: " + c.getTitulo());
        System.out.println("Autor: " + c.getAutor());
    }
}
