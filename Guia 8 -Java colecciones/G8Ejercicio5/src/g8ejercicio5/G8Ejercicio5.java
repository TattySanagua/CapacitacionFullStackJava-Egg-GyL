package g8ejercicio5;

import Entidades.Pais;
import Servicios.Serviciopais;
import Utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class G8Ejercicio5 {

    public static void main(String[] args) {
        
        Serviciopais servpais = new Serviciopais();
        
        HashSet<Pais> paisesSet = servpais.crearPaises();
        
        System.out.println("--------------");
        System.out.println("Paises ordenados alfabeticamente");
        ArrayList<Pais> paisesList = new ArrayList<>(paisesSet);
        Collections.sort(paisesList, Comparadores.ordenarAsc);
        for(Pais var : paisesList){
            System.out.println(var);
        }
        
        System.out.println("----");
        System.out.println("Ingrese el pais que desea eliminar del conjunto!!!");
        Scanner leer = new Scanner(System.in);
        servpais.eliminarPais(paisesSet, leer.next());
        for(Pais var : paisesSet){
            System.out.println(var);
        }
    }
    
}
