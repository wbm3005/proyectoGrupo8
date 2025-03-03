package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class NodoPila {
    
    private PremiosCastigos premiosCastigos;
    private NodoPila siguiente;

    /**
     * constructor sin parametros
     */
    public NodoPila() {
    }

    /**
     * Constructor que recibe como parametro un objeto de la clase PremiosCastigos e inicia el puntero en null
     * @param premiosCastigos objeto de la clase PremiosCastigos
     */
    public NodoPila(PremiosCastigos premiosCastigos) {
        this.premiosCastigos = premiosCastigos;
        this.siguiente = null;
    }

    // Getters y Setters
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
