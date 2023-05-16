
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
    //Escribir un programa que pida una frase y la muestre toda en mayúsculas y después toda 
    //en minúsculas. Nota: investigar la función toUpperCase() y toLowerCase() en Java.
    
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese una frase");
        
        String frase = leer.nextLine();
        
        System.out.println("La frase en mayúsculas es: " + frase.toUpperCase());
        
        System.out.println("La frase en minúsculas es: " + frase.toLowerCase());
    
    }
    
}
