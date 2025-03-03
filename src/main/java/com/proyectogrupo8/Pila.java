package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class Pila {
    
    private NodoPila cima;

    public Pila() {
        this.cima = null;
    }

    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }
    
    public boolean esVacia(){
        return cima == null;
    }
    
    public void apilar(PremiosCastigos premiosCastigos){
        NodoPila aux = new NodoPila(premiosCastigos);
        aux.setSiguiente(cima);
        cima = aux;
    }
    
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
