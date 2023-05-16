package g7ejercicio6;

import g7ejercicio6.entidades.Cafetera;
import g7ejercicio6.servicios.CafeteraServicio;

public class G7Ejercicio6 {

    public static void main(String[] args) {
        
        CafeteraServicio cs = new CafeteraServicio();
        
        Cafetera c = new Cafetera(1500,0);
        
        //cs.crearCafetera();
        
        cs.llenarCafetera(c);
        cs.servirTaza(c);
        //cs.vaciarCafetera(c);
        cs.agregarCafe(c);
        
        System.out.println("La cafetera tiene " + c.getCantidadActual() + "cc actualmente");
    }
    
}
