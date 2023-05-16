
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
    
    //Dada una cantidad de grados centígrados se debe mostrar su equivalente en grados 
    //Fahrenheit. La fórmula correspondiente es: F = 32 + (9 * C / 5).
    
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese el valor en grados Celsius (ºC)");
        
        double celsius = leer.nextDouble();
        
        double fahrenheit = 32 + (9*(celsius/5));
        
        System.out.println("La cantidad de grados ingresados en medida Fahrenheit es = " + fahrenheit + "ºF");
    
    }
    
}
