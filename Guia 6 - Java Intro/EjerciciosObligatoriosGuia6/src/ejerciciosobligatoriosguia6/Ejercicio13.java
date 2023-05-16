
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio13 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese un numero entero");
        int N = leer.nextInt();
        
        for(int i = 0; i < N; i++){
            
            for(int j = 0; j < N; j++){
                
                if(i > 0 && i < N-1 && j > 0 && j < N-1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
        
    }
    
}
