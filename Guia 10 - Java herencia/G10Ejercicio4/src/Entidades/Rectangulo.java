package Entidades;

import Interfaces.calculosFormas;

public class Rectangulo implements calculosFormas{

    private double base;
    private double altura;

    public Rectangulo() {
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    @Override
    public void areaPerimetroCirculo(double radio) {
        //No hace nada
    }

    @Override
    public void areaPerimetroRectangulo(double base, double altura) {
         
        System.out.println("*Área del Rectángulo = " + (base*altura));
        System.out.println("*5"
                + "Perímetro del Rectángulo = " + ((base+altura)*2));
    }
    
}
