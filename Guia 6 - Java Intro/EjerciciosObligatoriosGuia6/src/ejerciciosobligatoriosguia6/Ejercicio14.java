
package ejerciciosobligatoriosguia6;

import java.util.Scanner;

public class Ejercicio14 {

    public static void main(String[] args) {
      
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese cantidad de euros a convertir");
        double euros = leer.nextDouble();
        
        System.out.println("Ingrese a que moneda va a convertir(dolares, yenes, liras)");
        String moneda = leer.next();
        
        cambio(euros,moneda);
        
    }
    
    public static void cambio(double euros, String moneda){
        
        switch(moneda){
            case "liras":
                System.out.println("Liras " + 0.86*euros);break;
            case "yenes":
                System.out.println("Yenes " + 129.852*euros);break;
            case "dolares":
                System.out.println("Dolares " + 1.28611*euros);break;
            default:
                System.out.println("Conversion incorrecta");
        }
    }
}
