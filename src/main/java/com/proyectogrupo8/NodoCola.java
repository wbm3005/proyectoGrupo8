package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class NodoCola {
    
    private Jugador jugador;
    private NodoCola siguiente;

    /**
     * constructor sin parametros
     */
    public NodoCola() {
    }

    /**
     * constructor con parametros
     * @param jugador objeto de tipo/clase Jugador
     */
    public NodoCola(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }

    // Getters y Setters
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
}
