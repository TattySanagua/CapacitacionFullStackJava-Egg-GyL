package Entidades;

import java.util.List;

public class Baraja {
    
    private List<Carta> cartas;

    public Baraja() {
    }

    public Baraja(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Baraja{" + "cartas=" + cartas + '}';
    }
    
    
    
}
