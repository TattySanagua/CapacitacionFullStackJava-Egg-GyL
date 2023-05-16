
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        //Escriba un programa que pida una frase o palabra y valide si la primera letra de esa frase 
        //es una ‘A’. Si la primera letra es una ‘A’, se deberá de imprimir un mensaje por pantalla que 
        //diga “CORRECTO”, en caso contrario, se deberá imprimir “INCORRECTO”. Nota: investigar 
        //la función Substring y equals() de Java.
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese una frase que comience con A");
        
        String frase = leer.nextLine();
        
        
        if("A".equals(frase.substring(0,1)) || "a".equals(frase.substring(0,1))){
            System.out.println("CORRECTO");
        }else{
            System.out.println("INCORRECTO");
        }

    }
    
}
