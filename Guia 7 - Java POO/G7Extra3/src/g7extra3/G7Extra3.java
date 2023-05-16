package g7extra3;

import Entidades.Raices;
import Servicios.RaicesService;

public class G7Extra3 {

    public static void main(String[] args) {
        
        RaicesService rs = new RaicesService();
        
        Raices r = rs.crearRaices();
        
        rs.calcular(r);
        
        
    }
    
}
