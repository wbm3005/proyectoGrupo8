package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class Pila {
    
    private NodoPila cima;

    /**
     * constructor de la clase que inicia el puntero en null
     */
    public Pila() {
        this.cima = null;
    }

    // Getter y Setter
    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }
    
    /**
     * Metodo que verifica si la pila esta vacia o no
     * @return true o false dependiendo del estado de la pila
     */
    public boolean esVacia(){
        return cima == null;
    }
    
    /**
     * Metodo para agregar un elemento a la Pila
     * @param premiosCastigos objeto de tipo/clase PremiosCastigos
     */
    public void apilar(PremiosCastigos premiosCastigos){
        NodoPila aux = new NodoPila(premiosCastigos);
        aux.setSiguiente(cima);
        cima = aux;
    }
    
    /**
     * Metodo que elimina un elemento de la Pila
     * @return objeto de tipo/clase PremiosCastigos eliminado
     */
    public PremiosCastigos desapilar(){
        
        if (esVacia()){
            System.out.println("No se puede desapilar, la pila esta vacia");
            return null;
        }
        
        PremiosCastigos premioCastigoDesapilado = cima.getPremiosCastigos();
        cima = cima.getSiguiente();
        return premioCastigoDesapilado;
    }
}
