package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class Dados {
    
    private int valorDado1; //  valor del dado 1
    private int valorDado2; // valor del dado 2

    /**
     * Inicializa los dados cuando el constructor es instanciado
     * @param valorDado1 inicializa el dado 1 con el valor 0
     * @param valorDado2 inicializa el dado 2 con el valor 0
     */
    public Dados(int valorDado1, int valorDado2) {
        this.valorDado1 = 0;
        this.valorDado2 = 0;
    }

    // Getters y Setters
    public int getValorDado1() {
        return valorDado1;
    }

    public void setValorDado1(int valorDado1) {
        this.valorDado1 = valorDado1;
    }

    public int getValorDado2() {
        return valorDado2;
    }

    public void setValorDado2(int valorDado2) {
        this.valorDado2 = valorDado2;
    }
    
    /**
     * Tira los dados y les asigna un valor aleatorio por medio de la libreria Math.random
     */
    public void tirar() {
        setValorDado1((int)(Math.random() * 6) + 1);
        setValorDado2((int)(Math.random() * 6) + 1);
    }
    
    /**
     * Muestra los valores despues de haber tirado los dados
     * @return el valor de cada dado
     */
    public String mostrar(){
        return "El resultado de los dados es: " + getValorDado1() + " y " + getValorDado2(); 
    }
}
