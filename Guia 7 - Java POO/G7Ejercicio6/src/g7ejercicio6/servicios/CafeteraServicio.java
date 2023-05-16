package g7ejercicio6.servicios;

import g7ejercicio6.entidades.Cafetera;
import java.util.Scanner;

public class CafeteraServicio {

    private Scanner leer = new Scanner(System.in);
 
//    public Cafetera crearCafetera(){
//        
//        Cafetera c = new Cafetera(1500,0);
//        System.out.println("****" + c.getCapacidadMaxima());
//        return c;
//    }
    
    public void llenarCafetera(Cafetera c){
        //System.out.println("####" + c.getCapacidadMaxima());
        c.setCantidadActual(c.getCapacidadMaxima());
    }
    
    public void servirTaza(Cafetera c){
        
        System.out.println("Ingrese el tamaño de la taza a servir en cc");
        double tamanioTaza = leer.nextDouble();
        
        if(c.getCantidadActual() < tamanioTaza){
            
            System.out.println("Solo quedaban " + c.getCantidadActual() + "cc y se servio a su taza");
            c.setCantidadActual(0);
        }else{
            System.out.println("Su taza se lleno por completo con " + tamanioTaza + "cc");
            c.setCantidadActual(c.getCantidadActual() - tamanioTaza);
        }
        
    }
    
    public void vaciarCafetera(Cafetera c){
        
        c.setCantidadActual(0);
    }
    
    public void agregarCafe(Cafetera c){
        
        System.out.println("Ingrese cuanto café desea agregar");
        double cafe = leer.nextDouble();
        
        c.setCantidadActual(c.getCantidadActual() + cafe);
        
    }
}
