package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class NodoCola {
    
    private Jugador jugador;
    private NodoCola siguiente;

    public NodoCola() {
    }

    public NodoCola(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }

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
