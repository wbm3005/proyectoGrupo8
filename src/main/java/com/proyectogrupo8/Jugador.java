package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class Jugador {
    
    private String nombre;
    private int id;
    private int posicion;

    public Jugador() {
    }

    public Jugador(String nombre, int id, int posicion) {
        this.nombre = nombre;
        this.id = id;
        this.posicion = posicion;
    }

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
