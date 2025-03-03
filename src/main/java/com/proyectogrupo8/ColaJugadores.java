package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class ColaJugadores {
    
    private NodoCola frente;
    private NodoCola ultimo;

    public ColaJugadores() {
        this.frente = null;
        this.ultimo = null;
    }

    public NodoCola getFrente() {
        return frente;
    }

    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }
    
    
    public void encolar(Jugador jugador) {
        NodoCola aux = new NodoCola(jugador);
        aux.setJugador(jugador);

        if (this.ultimo != null) { // si la cola no esta vacia
            this.getUltimo().setSiguiente(aux);
        } else {  // si la cola esta vacia
            this.setFrente(aux);
        }
        this.setUltimo(aux);
    }
    
    public NodoCola desencolar() {
        NodoCola aux = new NodoCola();
        
        if (this.estaVacia()) {
            return null;
        } else {
            aux = this.frente;   // guarde el primer nodo en una variable temporal (para poderlo retornar despues de desencolar)
            this.frente = this.frente.getSiguiente();
            // si la cola queda vacia
            if (this.frente == null) {
                this.ultimo = null;
            }
        }
        return aux;
    }
    
    public NodoCola frente() {
        return this.frente;
    }

    public boolean estaVacia() {
        return this.frente == null;
    }
    
    
    public int cuentaParticipantes(){
    
        int cantidadJugadores = 0;
        NodoCola actual = frente;
        
        while (actual != null){
            cantidadJugadores++;
            actual = actual.getSiguiente();
        }
        return cantidadJugadores;
    }
    
    
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola de jugadores está vacía.");
        } else {
            NodoCola actual = getFrente();
            while (actual != null) {
                System.out.println(actual.getJugador().toString());
                actual = actual.getSiguiente();
            }
        }
    }
    
    public boolean removerJugadorPorId(int id){
        if (estaVacia()){
            return false;
        }
        
        // si el jugador a remover es el de la cabeza de la cola
        if (frente.getJugador().getId() == id){
            desencolar();
            return true;
        }
        NodoCola anterior = frente;
        NodoCola actual = frente.getSiguiente();
        
        while (actual != null){
            if (actual.getJugador().getId() == id){
                anterior.setSiguiente(actual.getSiguiente());
                // si se elimina el ultimo
                if (actual == ultimo){
                    ultimo = anterior;
                }
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }
}
