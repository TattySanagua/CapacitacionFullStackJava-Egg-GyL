
package g7ejercicio10.entidad;

public class Arreglo {
    
    private double[] A;
    private double[] B;

    public double[] getA() {
        return A;
    }

    public double[] getB() {
        return B;
    }

    public void setA(double[] A) {
        this.A = A;
    }

    public void setB(double[] B) {
        this.B = B;
    }

    public Arreglo() {
    }
    
    public Arreglo(double[] A, double[] B){
        this.A = A;
        this.B = B;
    }
    
    
}
