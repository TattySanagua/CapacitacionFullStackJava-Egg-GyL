package Servicios;

import Entidades.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicioPelicula {
    
    private ArrayList<Pelicula> peliculas;
    private Scanner leer;

    //Buena práctica
    public ServicioPelicula() {
        this.leer = new Scanner(System.in).useDelimiter("\n"); // Cuando se invoca la clase, habilita el flujo de datos
        this.peliculas = new ArrayList<>();
    }

   public ArrayList<Pelicula> crearPeli(){
 
       String opcion = "Si";
       
       while(opcion.equalsIgnoreCase("si")){
           
           String titulo;
           String director;
           double duracion;
           
           
           System.out.println("Ingrese titulo de la película");
           titulo = leer.next();
           
           System.out.println("Ingrese director de la película");
           director = leer.next();
           
           System.out.println("Ingrese duracion de la película");
           duracion = leer.nextDouble();
           
           Pelicula peli = new Pelicula(titulo,director,duracion);
           
           peliculas.add(peli);
           
           System.out.println("Quiere agregar otra pelicula? (Si,No)");
           opcion = leer.next();
           
           System.out.println("");
       }
       
       return peliculas;
   }
    
   public void mostrarPeliculas(ArrayList<Pelicula> peliculas){
       
       for(Pelicula elemento : peliculas){
           
           System.out.println(elemento.toString());
       }
   }
   
   public void duracionMayor1hora(ArrayList<Pelicula> peliculas){
       
       for(Pelicula elemento : peliculas){
           
           if(elemento.getDuracion() > 1){
               System.out.println(elemento.toString());
           }
           
       }
   }
}
