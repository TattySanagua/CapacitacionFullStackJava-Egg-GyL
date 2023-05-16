
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese una cadena que empiece con X y termine con O, y que sea de 5 caracteres como máximo");
        String cadena = leer.next();
        
        int correcta = 0;
        int incorrecta = 0;
        String fde = "&&&&&";
        
        while(!cadena.equals(fde)){
            
           if(cadena.substring(0,1).equals("X") && cadena.substring(cadena.length()-1, cadena.length()).equals("O") && cadena.length() <= 5){
               correcta++;
            }else{
                incorrecta++;
            }
            
        System.out.println("Ingrese una cadena que empiece con X y termine con O, y que sea de 5 caracteres como máximo");
        cadena = leer.next();
        }
        
        System.out.println("Cantidad de cadenas correctas " + correcta);
        System.out.println("Cantidad de cadenas incorrectas " + incorrecta);
    }
    
}
