
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
    
    //Escribir un programa que pida tu nombre, lo guarde en una variable y lo muestre por pantalla.
    
       Scanner leer = new Scanner(System.in);
       
       String nombre;
       
       System.out.println("Ingrese su nombre");
        
       nombre = leer.nextLine();
       
        System.out.println("Su nombre es " + nombre);
    }
    
}
