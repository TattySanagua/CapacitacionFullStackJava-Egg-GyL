package g9ejercicio1;

import Entidades.Perro;
import Entidades.Persona;

public class G9Ejercicio1 {

    public static void main(String[] args) {
        
        Perro perro1 = new Perro("Kitty","Salchicha", 11,"Pequeño");
        
        Persona p1 = new Persona("Tatiana","Sanchez",32,12345,perro1);
        
        Perro perro2 = new Perro("Dilara","Caniche",4,"Pequeño");
        
        Persona p2 = new Persona("Leonel","Barrios",22,54321,perro2);
        
        System.out.println(p1.toString());
        
        System.out.println("------------------------------------");
        
        System.out.println(p2.toString());
        
        System.out.println("------------------------------------");
        
        //Otra forma:
        
        Perro perro3 = new Perro();
        
        perro3.setNombre("Dalton");
        perro3.setRaza("Labrador");
        perro3.setEdad(10);
        perro3.setTamanio("Grande");
        
        Persona p3 = new Persona();
        
        p3.setNombre("Emanuel");
        p3.setApellido("Diaz");
        p3.setEdad(32);
        p3.setDni(34567);
        p3.setPerro(perro3);
        
        System.out.println(p3.toString());
    }
    
}
