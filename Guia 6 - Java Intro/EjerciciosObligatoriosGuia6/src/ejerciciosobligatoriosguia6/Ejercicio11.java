
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese el primer numero entero");
        
        double num1 = leer.nextDouble();
        
        System.out.println("Ingrese el segundo numero entero");
        
        double num2 = leer.nextDouble();
        
        String confirmacion = "N";
        double operacion;
        
        while(!"S".equals(confirmacion)){
            System.out.println("MENU");
            System.out.println("1.Sumar");
            System.out.println("2.Restar");
            System.out.println("3.Multiplicar");
            System.out.println("4.Dividir");
            System.out.println("5.Salir");
            System.out.println("Elija opción:");
        
            int opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    operacion = num1 + num2;
                    System.out.println("Suma = " + operacion);
                    break;
                case 2:
                    operacion = num1 - num2;
                    System.out.println("Resta = " + operacion);
                    break;
                case 3:
                    operacion = num1 * num2;
                    System.out.println("Multiplicacion = " + operacion);
                    break;
                case 4:
                    operacion = num1 / num2;
                    System.out.println("Division = " + operacion);
                    break;
                case 5:
                    System.out.println("Esta seguro que desea salir (S/N)?");
                    confirmacion = leer.next();
                    break;
                default:
                    System.out.println("Debe elegir una opcion valida");
                    break;
            }
        }
    }
    
}
