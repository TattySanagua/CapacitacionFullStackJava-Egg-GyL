package g8ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class G8Ejercicio1 {

    public static void main(String[] args) {
        
        ArrayList<String> razas = new ArrayList<>();
        
        Scanner leer = new Scanner(System.in);

        String opcion = "SI";
        
        while(opcion.equalsIgnoreCase("si")){
            System.out.println("Ingrese una raza de perros");
            razas.add(leer.next());
            
            System.out.println("Desea agregar otra raza? (SI, NO)");
            opcion = leer.next();
        }
        
        razas.forEach((elemento) -> {
            System.out.print(elemento + " ");
        });
        
        System.out.println(" ");
        System.out.println("Ingrese una raza de perro");
        String raza = leer.next();
        
        Iterator<String> iter = razas.iterator();
        
        int cont = 0;
        
        while(iter.hasNext()){
            String aux = iter.next();
            
            if(aux.equalsIgnoreCase(raza)){
                iter.remove();
                cont++;
            }
            
        }
        
        if(cont == 0){
            System.out.println("La raza no esta en la lista");
        }
        
         razas.forEach((elemento) -> {
            System.out.print(elemento + " ");
        });
    }
    
}
