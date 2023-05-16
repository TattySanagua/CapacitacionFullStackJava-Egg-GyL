package g7extra1;

import Entidades.Cancion;
import Servicios.CancionServicio;

public class G7Extra1 {

    public static void main(String[] args) {
        
        CancionServicio cs = new CancionServicio();
        
        Cancion c = cs.crearCancion();
        
        cs.mostrarCancion(c);
        
    }
    
}
