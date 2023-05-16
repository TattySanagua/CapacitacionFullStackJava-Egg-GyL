
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
    //Escribir un programa que lea un número entero por teclado y muestre por pantalla el 
    //doble, el triple y la raíz cuadrada de ese número. Nota: investigar la función Math.sqrt().
    
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese un número entero");
        
        double num = leer.nextDouble();
        double raizCuad = Math.sqrt(num);
        
        System.out.println("El doble del valor es = " + 2*num);
        System.out.println("El triple del valor es = " + 3*num);
        System.out.println("La raiz cuadrada del valor es = " + raizCuad);
    
    }
    
}
