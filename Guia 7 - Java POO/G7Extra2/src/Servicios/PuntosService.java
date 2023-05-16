package Servicios;

import Entidades.Puntos;
import java.util.Scanner;

public class PuntosService {
    
    Scanner leer = new Scanner(System.in);
    
    public Puntos crearPuntos(){
        
        Puntos p = new Puntos();
        
        System.out.println("Ingrese x1");
        p.setX1(leer.nextDouble());
        
        System.out.println("Ingrese y1");
        p.setY1(leer.nextDouble());
        
        System.out.println("Ingrese x2");
        p.setX2(leer.nextDouble());
        
        System.out.println("Ingrese y2");
        p.setY2(leer.nextDouble());
        
        return p;
    }
    
    public double calcularDistancia(Puntos p){
        
        double x1 = p.getX1();
        double y1 = p.getY1();
        double x2 = p.getX2();
        double y2 = p.getY2();
        
        double distancia = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
        
        return distancia;
    }
}
