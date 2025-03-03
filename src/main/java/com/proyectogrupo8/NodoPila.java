package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class NodoPila {
    
    private PremiosCastigos premiosCastigos;
    private NodoPila siguiente;

    public NodoPila() {
    }

    public NodoPila(PremiosCastigos premiosCastigos) {
        this.premiosCastigos = premiosCastigos;
        this.siguiente = null;
    }

    public PremiosCastigos getPremiosCastigos() {
        return premiosCastigos;
    }

    public void setPremiosCastigos(PremiosCastigos premiosCastigos) {
        this.premiosCastigos = premiosCastigos;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}
