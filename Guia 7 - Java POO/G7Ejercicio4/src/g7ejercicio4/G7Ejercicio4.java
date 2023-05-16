
package g7ejercicio4;

import g7ejercicio4.entidad.Rectangulo;
import g7ejercicio4.servicio.RectanguloServicio;

public class G7Ejercicio4 {

    public static void main(String[] args) {
      
        RectanguloServicio rs = new RectanguloServicio();
        
        Rectangulo r = rs.crearRectangulo();
        
        System.out.println("Superficie = " + rs.superficie(r.getBase(), r.getAltura()));
        System.out.println("Perímetro = " + rs.perimetro(r.getBase(), r.getAltura()));
        System.out.println("Figura");
        rs.figura(r.getBase(), r.getAltura());
    }
    
}
