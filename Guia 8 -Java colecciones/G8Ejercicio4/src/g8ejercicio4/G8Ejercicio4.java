package g8ejercicio4;

import Entidades.Pelicula;
import Servicios.ServicioPelicula;
import Utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;

public class G8Ejercicio4 {

    public static void main(String[] args) {
        
        ServicioPelicula servPeli = new ServicioPelicula();
        
        ArrayList<Pelicula> peliculas = servPeli.crearPeli();
        
        System.out.println("Listado de todas las películas: ");
        servPeli.mostrarPeliculas(peliculas);
        
        System.out.println("----------");
        System.out.println("Películas con duración mayor a 1 hora: ");
        servPeli.duracionMayor1hora(peliculas);
        
        System.out.println("----------");
        System.out.println("Películas ordenadas por duracion de menor a mayor");
        Collections.sort(peliculas,Comparadores.ordenarDuracionDesc);
        for(Pelicula elemento : peliculas){
            System.out.println(elemento);
        }
        
        System.out.println("----------");
        System.out.println("Películas ordenadas por duracion de mayor a menor");
        Collections.sort(peliculas,Comparadores.ordenarDuracionAsc);
        for(Pelicula elemento : peliculas){
            System.out.println(elemento);
        }
        
        System.out.println("----------");
        System.out.println("Películas ordenadas por titulo alfabeticamente");
        Collections.sort(peliculas,Comparadores.ordenarTituloAsc);
        for(Pelicula elemento : peliculas){
            System.out.println(elemento);
        }
        
        System.out.println("----------");
        System.out.println("Películas ordenadas por director alfabeticamente");
        Collections.sort(peliculas,Comparadores.ordenarDirectorAsc);
        for(Pelicula elemento : peliculas){
            System.out.println(elemento);
        }
    }
    
}
