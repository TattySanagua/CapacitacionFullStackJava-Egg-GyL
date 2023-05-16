
package g7extra4;

import Entidades.NIF;
import Services.NIFService;

public class G7Extra4 {

    public static void main(String[] args) {
        
        NIFService nifs = new NIFService();
        
        NIF nif = nifs.crearNIF();
        
        nifs.mostrar(nif);
        
    }
    
}
