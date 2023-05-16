
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        // Crear un programa que pida una frase y si esa frase es igual a “eureka” el programa 
        //pondrá un mensaje de Correcto, sino mostrará un mensaje de Incorrecto. Nota: investigar 
        //la función equals() en Java.
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese la frase: eureka");
        String frase = leer.nextLine();
        
        do {
            
            System.out.println("Incorrecto!");
            System.out.println("Ingrese la frase: eureka");
            frase = leer.nextLine();
            
        } while (!"eureka".equals(frase)); //equals Sirve para comparar si dos cadenas son iguales. 
                                            //Devuelve true si son iguales y false si no.
        
        if("eureka".equals(frase)){
            System.out.println("Correcto!");
        }
    }
    
}
