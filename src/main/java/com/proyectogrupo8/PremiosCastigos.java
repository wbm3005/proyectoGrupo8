package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class PremiosCastigos {
    
    private String operacion;
    private int numeroPosiciones;
    private String descripcion;

    public PremiosCastigos() {
    }

    public PremiosCastigos(String operacion, int numeroPosiciones, String descripcion) {
        this.operacion = operacion;
        this.numeroPosiciones = numeroPosiciones;
        this.descripcion = descripcion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getNumeroPosiciones() {
        return numeroPosiciones;
    }

    public void setNumeroPosiciones(int numeroPosiciones) {
        this.numeroPosiciones = numeroPosiciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Operacion : " + operacion + ", posiciones : " + numeroPosiciones +
               ", descripcion : " + descripcion;
    }

}
