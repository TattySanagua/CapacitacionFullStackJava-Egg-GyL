
package Servicios;

import Entidades.Persona;
import java.util.Scanner;

public class PersonaService {
    
    private Scanner leer;

    public PersonaService() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void crearPersona(){
        
        try {
            
            Persona p = new Persona();
            
            String[] lista = new String[3];
            
            System.out.println("Cuantos apodos tiene la persona? Puede agregar hasta 3");
            
            int cantidad = leer.nextInt();
            
            for(int i = 0; i < cantidad; i++){
                
                System.out.print("Agregue el apodo " + (i+1) + "-");
                
                lista[i] = leer.next();
            }
            
            p.setApodos(lista);
            
           
            
        } catch (ArrayIndexOutOfBoundsException e) {
            
            System.out.println("Error: sobrepasó el límite de " + e.getMessage());
        }
    }
}
