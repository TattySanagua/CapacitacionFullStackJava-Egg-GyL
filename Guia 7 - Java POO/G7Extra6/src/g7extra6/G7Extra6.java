package g7extra6;

import Entidades.Ahorcado;
import Services.AhorcadoService;

public class G7Extra6 {

    public static void main(String[] args) {
        
        AhorcadoService as = new AhorcadoService();
        
        Ahorcado juego = new Ahorcado();
        
        as.juego(juego);
    }
    
}
