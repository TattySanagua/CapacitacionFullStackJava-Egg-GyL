
package g7ejercicio7.servicio;

import g7ejercicio7.entidad.Persona;
import java.util.Scanner;

public class PersonaServicio {
    
    private Scanner leer = new Scanner(System.in);
    
    public Persona crearPersona(){
        
        System.out.println("Ingrese su nombre");
        String nombre = leer.next();
        
        System.out.println("Ingrese su edad");
        int edad = leer.nextInt();
        
        System.out.println("Ingrese el sexo(H,M,O)");
        String sexo = leer.next();
        
        while((!sexo.equalsIgnoreCase("h")) && (!sexo.equalsIgnoreCase("m")) && (!sexo.equalsIgnoreCase("o"))){
            
            System.out.println("Debe ingresar un sexo valido");
            System.out.println("Ingrese nuevamente el sexo(H,M,O)");
            sexo = leer.next();
        }
        
        Persona p = new Persona(nombre,edad,sexo);
        return p;
    }
    
    public int calcularIMC(Persona p){
        
        System.out.println("Ingrese peso");
        p.setPeso(leer.nextDouble());
        
        System.out.println("Ingrese altura");
        p.setAltura(leer.nextDouble());
        
        double imc = p.getPeso() / (p.getAltura()*p.getAltura());
        
        if(imc < 20){
            System.out.println(p.getNombre() + " está por debajo de su peso ideal");
            return -1;
        }else if(imc >=20 && imc<=25){
            System.out.println(p.getNombre() + " está en su peso ideal");
            return 0;
        }else{
            System.out.println(p.getNombre() + " está por encima de su peso ideal");
            return 1;
        }
        
    }
    
    public boolean mayorDeEdad(Persona p){
        
        if(p.getEdad() >= 18){
            System.out.println(p.getNombre() + " es mayor de edad");
            return true;
        }else{
            System.out.println(p.getNombre() + " es menor de edad");
            return false;
        }
    }
}
