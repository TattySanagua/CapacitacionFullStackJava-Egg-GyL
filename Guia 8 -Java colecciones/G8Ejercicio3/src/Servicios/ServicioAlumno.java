package Servicios;

import Entidades.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicioAlumno {
    
    private Scanner leer = new Scanner(System.in);
    
    public ArrayList<Alumno> crearAlumno(){
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        
        
        String opcion = "Si";
        
        while(opcion.equalsIgnoreCase("si")){
            String nombre;
            ArrayList<Integer> notasAlumno = new ArrayList<>();
            
            System.out.println("Ingrese el nombre del alumno");
            nombre = leer.next();
            
            System.out.println("Ingrese la primera nota");
            notasAlumno.add(leer.nextInt());
            
            System.out.println("Ingrese la segunda nota");
            notasAlumno.add(leer.nextInt());
            
            System.out.println("Ingrese la tercera nota");
            notasAlumno.add(leer.nextInt());
            
             Alumno alumno = new Alumno(nombre,notasAlumno);
            
             alumnos.add(alumno);
             
             System.out.println("Desea agregar otro alumno? (Si,No)");
             opcion = leer.next();
        }
        
        return alumnos;
    }
    
    public void mostrarAlumnos(ArrayList<Alumno> alumnos){
        
        for(Alumno elemento : alumnos){
            System.out.println(elemento.toString());
        }
    }
    
    public double notaFinal(ArrayList<Alumno> alumnos, String nombre){
        
        int suma = 0;
        
        for(Alumno alumno : alumnos){
            
            if(alumno.getNombre().equalsIgnoreCase(nombre)){
                
                for(int i = 0; i < alumno.getNotas().size(); i++){
                    suma = suma + alumno.getNotas().get(i);
                }
            }
        }
        
        return suma/3;
    }
}
