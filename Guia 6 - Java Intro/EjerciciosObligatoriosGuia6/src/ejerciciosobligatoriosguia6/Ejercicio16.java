
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio16 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese el tamaño del vector");
        int N = leer.nextInt();

        int[] vector = new int[N];
        
        for(int i = 0; i < N; i++){
            
            vector[i] = (int) (Math.random() * 101);
            
        }
        
        for(int i = 0; i < N; i++){
            System.out.print(vector[i] + " ");
        }
        
        System.out.println("");
        System.out.println("Ingrese un numero a buscar en el vector");
        int num = leer.nextInt();
        int cont = 0;
        
        for(int i = 0; i < N; i++){
            
            if(vector[i] == num){
                System.out.println("El numero se encuentra en el vector en la posicion " + (i+1));
                cont++;
            }
            
        }
        
        if(cont == 0){
            System.out.println("El numero no se encuentra en el vector");
        }else if(cont > 1){
            System.out.println("El numero se encuentra repetido " + cont + " veces");
        }
        
    }
    
}
