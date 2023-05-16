
package g7ejercicio7;

import g7ejercicio7.entidad.Persona;
import g7ejercicio7.servicio.PersonaServicio;

public class G7Ejercicio7 {

    public static void main(String[] args) {
        
        PersonaServicio ps = new PersonaServicio();
        
        Persona p1 = ps.crearPersona();
        int imc1 = ps.calcularIMC(p1);
        boolean edad1 = ps.mayorDeEdad(p1);
        
        System.out.println("");
        
        Persona p2 = ps.crearPersona();
        int imc2 = ps.calcularIMC(p2);
        boolean edad2 = ps.mayorDeEdad(p2);
        
        System.out.println("");
        
        Persona p3 = ps.crearPersona();
        int imc3 = ps.calcularIMC(p3);
        boolean edad3 = ps.mayorDeEdad(p3);
         
        System.out.println("");
        
        Persona p4 = ps.crearPersona();
        int imc4 = ps.calcularIMC(p4);
        boolean edad4 = ps.mayorDeEdad(p4);
        
        int cont1 = 0;
        int cont2 = 0;
        
        int[] imc = new int[4];
        
        imc[0] = imc1;imc[1] = imc2;imc[2] = imc3;imc[3] = imc4;
        
        for(int i = 0; i < 4; i++){
            if(imc[i] == -1){
                cont1++;
            }else if(imc[i] == 1){
                cont2++;
            }
        }
        
        System.out.println("");
        System.out.println("porcentaje de personas por debajo de su peso ideal = " + (cont1*100)/4);
        System.out.println("porcentaje de personas por encima de su peso ideal = " + (cont2*100)/4);

        int cont3 = 0;
        int cont4 = 0;
        
        boolean[] mayores = new boolean[4];
        
        mayores[0] = edad1; mayores[1] = edad2; mayores[2] = edad3; mayores[3] = edad4;
        
        for(int i = 0; i < 4; i++){
            if(mayores[i]){
                cont3++;
            }else if(!mayores[i]){
                cont4++;
            }
        }
        
        System.out.println("porcentaje de personas mayores de edad = " + (cont3*100)/4);
        System.out.println("porcentaje de personas menores de edad = " + (cont4*100)/4);

          //Ejercicio 1 Guia 11 (Exceptions)
          
          try {
                Persona p = new Persona();
                p = null;
          
                System.out.println("Es mayor de edad?" + ps.mayorDeEdad(p));
        
          } catch (Exception e) {
              
              System.out.println("No es posible determinar si es mayor de edad, faltan datos");
        }
          
          

    }
    
}
