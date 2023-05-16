package Entidades;

import Interfaces.calculosFormas;

public class Circulo implements calculosFormas{

    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    
    @Override
    public void areaPerimetroCirculo(double radio) {
        
        System.out.println("*Área del Círculo = " + (Math.PI*(Math.pow(radio, 2))));
        System.out.println("*Perímetro del Círculo = " + (Math.PI*2*radio));
    }

    @Override
    public void areaPerimetroRectangulo(double base, double altura) {
       //No hace nada
    }
    
    
}
