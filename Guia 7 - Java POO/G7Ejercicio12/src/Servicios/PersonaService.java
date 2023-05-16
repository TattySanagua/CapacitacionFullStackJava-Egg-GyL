package Servicios;

import Entidad.Persona;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class PersonaService {
    
    Scanner leer = new Scanner(System.in);
    
    public Persona crearPersona(){
        
        System.out.println("Ingrese el nombre");
        String nombre = leer.next();
        
        System.out.println("Ingrese dia de nacimiento");
        int dia = leer.nextInt();
        
        System.out.println("Ingrese mes de nacimiento");
        int mes = leer.nextInt();
        
        System.out.println("Ingrese anio de nacimineto");
        int anio = leer.nextInt();
        
        LocalDate fechaNac = LocalDate.of(anio, mes, dia);
        
        Persona p = new Persona(nombre,fechaNac);
        
        return p;
    }
    
    public int calcularEdad(Persona p){

        LocalDate fechaActual = LocalDate.now();
        
        Period edad = Period.between(p.getFechaNacimiento(),fechaActual);
        
        return edad.getYears();
    }
    
    public boolean menorQue(Persona p, int edad2){
        
        PersonaService ps = new PersonaService();
        
        int edad1 = ps.calcularEdad(p);
        
        return edad1 < edad2;
    }
    
    public void mostrarPersona(Persona p){
        
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Fecha de nacimiento: " + p.getFechaNacimiento());
    }
}
