package Entidades;

import java.util.ArrayList;

public class Juego {
    
    private ArrayList<Jugador> jugadores;
    private RevolverDeAgua revolver;

    public Juego() {
    }

    public Juego(ArrayList<Jugador> jugadores, RevolverDeAgua revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public RevolverDeAgua getRevolver() {
        return revolver;
    }

    public void setRevolver(RevolverDeAgua revolver) {
        this.revolver = revolver;
    }
    
    //Metodos
    
    public void llenarJuego(ArrayList<Jugador> listaJugadores, RevolverDeAgua rev){
        
        jugadores = listaJugadores;
        revolver = rev;
        
    }
    
    public boolean ronda(int jugador){
        
        boolean sigue = true;
        
        jugadores.get(jugador).disparo(revolver); //Genera el disparo para 1 jugador de la lista
        
        if(jugadores.get(jugador).isMojado()){
            sigue = false;
        }
        
        return sigue;
    }
}
