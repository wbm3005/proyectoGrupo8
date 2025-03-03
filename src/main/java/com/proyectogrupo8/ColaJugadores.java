package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class ColaJugadores {
    
    private NodoCola frente;
    private NodoCola ultimo;

    /**
     * constructor, inicializa los punteros en null 
     */
    public ColaJugadores() {
        this.frente = null;
        this.ultimo = null;
    }

    // Getters y Setters
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
    
    /**
     * Metodo para agregar un jugador a la cola
     * @param jugador objeto de tipo/clase Jugador el cual se va a encolar
     */
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
    
    /**
     * Metodo para eliminar un jugador de la cola
     * @return un objeto aux el cual contiene los datos del nodo eliminado
     */
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
    
    /**
     * Metodo para obtener el primer elemento de la cola
     * @return retorna el primer elemento de la cola
     */
    public NodoCola frente() {
        return this.frente;
    }

    /**
     * Metodo para verificar si la cola esta vacia o no
     * @return true o false dependiendo del estado de la cola
     */
    public boolean estaVacia() {
        return this.frente == null;
    }
    
    /**
     * Metodo para mostrar los elementos dentro de la cola
     */
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
    
    /**
     * Remueve de la cola el jugador cuyo ID coincide con el parametro dado
     * @param id id del jugador que quiere salir del juego
     * @return {@code true} si encontro y removio un jugador con el ID especificado
     *         {@code false} no encontro un jugador con el ID especificado
     */
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
