package com.proyectogrupo8;

/**
 *
 * @author willi
 */
public class PremiosCastigos {
    
    private String operacion;
    private int numeroPosiciones;
    private String descripcion;

    /**
     * constructor sin parametros
     */
    public PremiosCastigos() {
    }

    /**
     *
     * @param operacion operacion a realizar '"+", "-", "="'
     * @param numeroPosiciones valor que otorga el premio o castigo recibido
     * @param descripcion descripcion del premio o castigo
     */
    public PremiosCastigos(String operacion, int numeroPosiciones, String descripcion) {
        this.operacion = operacion;
        this.numeroPosiciones = numeroPosiciones;
        this.descripcion = descripcion;
    }

    
    // Getters y Setters
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
