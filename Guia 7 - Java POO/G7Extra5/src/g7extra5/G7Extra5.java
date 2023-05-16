
package g7extra5;

import Entidades.Meses;
import Services.MesesService;

public class G7Extra5 {

    public static void main(String[] args) {
       
       MesesService ms = new MesesService();
        
       Meses m = ms.inicializar();
       
       ms.adivinarMesSecreto(m);
    }
    
}
