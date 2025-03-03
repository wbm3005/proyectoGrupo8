package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class PilaPremios extends Pila {

    public PilaPremios() {
        super();
    }
    
    public void mostrarPila() {
        if (esVacia()) {
            System.out.println("La pila de premios esta vacia.");
        } else {
            NodoPila actual = getCima();
            while (actual != null) {
                System.out.println(actual.getPremiosCastigos().toString());
                actual = actual.getSiguiente();
            }
        }
    }
    
}
