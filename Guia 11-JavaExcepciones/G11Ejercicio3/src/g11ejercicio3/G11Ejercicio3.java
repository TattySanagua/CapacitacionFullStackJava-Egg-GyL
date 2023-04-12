package g11ejercicio3;

import Entidades.DivisionNumero;
import java.util.InputMismatchException;
import java.util.Scanner;

public class G11Ejercicio3 {

    public static void main(String[] args) {
       
        
        Scanner leer = new Scanner(System.in);
        
        DivisionNumero dn = new DivisionNumero();
        
        try {
            
            System.out.println("Ingrese el primer numero");
        
            String a = leer.next();
        
            System.out.println("Ingrese el segundo numero");
        
            String b = leer.next();
            
            dn.setNumero1(Integer.parseInt(a));
            dn.setNumero2(Integer.parseInt(b));
            
        } catch (InputMismatchException e) {
            
            System.out.println("Error: no se pudo leer la entrada" + e.getMessage());
            
        }catch(NumberFormatException e){
            
            System.out.println("Error: no se pudo convertir a entero" + e.getMessage());
        }
        
         
        
        
        try {
            
            System.out.println("La division entre numero1 y numero2 es = " + (dn.getNumero1()/dn.getNumero2()));
            
        } catch (ArithmeticException e) {
            
            System.out.println("Error: division por cero");
        }
    }
    
}
