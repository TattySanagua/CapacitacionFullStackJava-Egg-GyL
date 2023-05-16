package g8ejercicio3;

import Entidades.Alumno;
import Servicios.ServicioAlumno;
import java.util.ArrayList;
import java.util.Scanner;

public class G8Ejercicio3 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        ServicioAlumno servAlum = new ServicioAlumno();
        
        ArrayList<Alumno> alumnos = servAlum.crearAlumno();
        
        servAlum.mostrarAlumnos(alumnos);
        
        System.out.println("Ingrese el nombre del alumno para calcular su nota final");
        String nombre = leer.next();
        
        System.out.println("Nota final del alumno " + nombre + " = " + servAlum.notaFinal(alumnos, nombre));
        
    }
    
}
