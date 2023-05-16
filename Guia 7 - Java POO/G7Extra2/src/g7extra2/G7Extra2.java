package g7extra2;

import Entidades.Puntos;
import Servicios.PuntosService;

public class G7Extra2 {

    public static void main(String[] args) {
        
        PuntosService ps = new PuntosService();
        
        Puntos p = ps.crearPuntos();
        
        System.out.println("Distancia: " + ps.calcularDistancia(p));
        
    }
    
}
