package com.proyectogrupo8;

/**
 * Representa un jugador con sus atributos necesarios para el juego
 * @author willi
 */
public class Jugador {
    
    private String nombre;
    private int id;
    private int posicion;

    /**
     * constructor sin parametros
     */
    public Jugador() {
    }

    /**
     * constructor con parametros
     * @param nombre nombre del jugador
     * @param id id del jugador en el juego
     * @param posicion posicion del jugador en el tablero
     */
    public Jugador(String nombre, int id, int posicion) {
        this.nombre = nombre;
        this.id = id;
        this.posicion = posicion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", id de juego: " + id +
               ", posición : " + posicion;
    }
}
