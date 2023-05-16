package Servicios;

import Entidades.Raices;
import java.util.Scanner;

public class RaicesService {
    
    Scanner leer = new Scanner(System.in);
    
    public Raices crearRaices(){
        
        Raices r = new Raices();
        
        System.out.println("Ingrese los valores de los coeficientes para la ecuación de segundo grado");
        System.out.print("a: ");
        r.setA(leer.nextDouble());
        System.out.print("b: ");
        r.setB(leer.nextDouble());
        System.out.print("c: ");
        r.setC(leer.nextDouble());
        
        return r;
    }
    
    public double getDiscriminante(Raices r){
        
        double a = r.getA();
        double b = r.getB();
        double c = r.getC();
        
        return (Math.pow(b,2))-(4*a*c);
        
    }
    
    public boolean tieneRaices(Raices r){
        
        RaicesService rs = new RaicesService();
        
        return rs.getDiscriminante(r) > 0;
    }
    
    public boolean tieneRaiz(Raices r){
        
        RaicesService rs = new RaicesService();
        
        return rs.getDiscriminante(r) == 0;
    }
    
    public void obtenerRaices(Raices r){
        
        RaicesService rs = new RaicesService();
        
        double a = r.getA();
        double b = r.getB();
        double c = r.getC();
        
        double raiz1 = -b+(Math.sqrt((Math.pow(b,2))-(4*a*c)));
        double raiz2 = -b-(Math.sqrt((Math.pow(b,2))-(4*a*c)));
        
        if(rs.tieneRaices(r)){
            System.out.println("La raiz 1 es " + raiz1 + " y la raiz 2 es " + raiz2);
        }
    }
    
    public void obtenerRaiz(Raices r){
        
        RaicesService rs = new RaicesService();
        
        double b = r.getB();
        
        double raiz = -b;
        
        if(rs.tieneRaiz(r)){
            System.out.println("La unica raiz posible es " + raiz);
        }
    }
    
    public void calcular(Raices r){
        
        RaicesService rs = new RaicesService();
        
        if(rs.tieneRaices(r)){
            rs.obtenerRaices(r);
        }else if(rs.tieneRaiz(r)){
            rs.obtenerRaiz(r);
        }else{
            System.out.println("No es posible calcular las raices");
        }
        
    }
}
