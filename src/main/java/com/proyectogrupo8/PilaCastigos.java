package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class PilaCastigos extends Pila {

    public PilaCastigos() {
        super();
    }
    
    /**
     * Muestra los elementos de la Pila castigos
     */
    public void mostrarPila() {
        if (esVacia()) {
            System.out.println("La pila de castigos esta vacia.");
        } else {
            NodoPila actual = getCima();
            while (actual != null) {
                System.out.println(actual.getPremiosCastigos().toString());
                actual = actual.getSiguiente();
            }
        }
    }
}
