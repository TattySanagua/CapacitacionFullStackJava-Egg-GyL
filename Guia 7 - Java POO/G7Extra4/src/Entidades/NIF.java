package Entidades;

public class NIF {
    
    private int dni;
    private char letra;

    public NIF() {
    }
    
    public NIF(int dni, char letra) {
        this.dni = dni;
        this.letra = letra;
    }

    public long getDni() {
        return dni;
    }

    public char getLetra() {
        return letra;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

}
