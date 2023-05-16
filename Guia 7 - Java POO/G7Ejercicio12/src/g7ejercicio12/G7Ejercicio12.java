package g7ejercicio12;

import Entidad.Persona;
import Servicios.PersonaService;
import java.util.Scanner;

public class G7Ejercicio12 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        PersonaService ps = new PersonaService();
        
        Persona p = ps.crearPersona();
        
        ps.mostrarPersona(p);
        
        int edad = ps.calcularEdad(p);
        
        System.out.println("Ingrese una edad nueva");
        int edadNueva = leer.nextInt();
        
        System.out.println("La edad ingresada es mayor a la edad de la primera persona: " + ps.menorQue(p, edadNueva));
        
    }
    
}
