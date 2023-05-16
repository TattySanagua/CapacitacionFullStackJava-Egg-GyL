
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        //Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación solicite 
        //números al usuario hasta que la suma de los números introducidos supere el límite inicial.
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese un valor limite positivo");
        
        int limite = leer.nextInt();
        
        int num, suma = 0;
        
        for(int i = 0; i < 100; i++){
            
            System.out.println("Ingrese un numero entero");
            num = leer.nextInt();
            suma = suma + num;
            
            if(suma>limite){
                break;
            }
            
        }
        System.out.println("La suma(" + suma + ") de los numeros ingresados superó el limite (" + limite + ")");
    }
    
}
