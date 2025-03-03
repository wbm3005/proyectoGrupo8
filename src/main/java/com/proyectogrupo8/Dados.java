package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class Dados {
    
    private int valorDado1; //  valor del dado 1
    private int valorDado2; // valor del dado 2

    public Dados(int valorDado1, int valorDado2) {
        this.valorDado1 = 0;
        this.valorDado2 = 0;
    }

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
    
    public void tirar() {
        setValorDado1((int)(Math.random() * 6) + 1);
        setValorDado2((int)(Math.random() * 6) + 1);
    }
    
    public String mostrar(){
        return "El resultado de los dados es: " + getValorDado1() + " y " + getValorDado2(); 
    }
}
