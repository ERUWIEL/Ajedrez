package piezas;

import java.util.List;

import objetos.Casilla;
import objetos.Movimiento;
import objetos.Tablero;

/**
 * Clase padre que modela las piezas de ajedrez
 * 
 * @author erwbiel
 */
public abstract class Pieza {

    protected String nombre;
    protected Tipo tipoPieza;
    protected Casilla posicion;
    protected String iconoRuta;

    /**
     * Metodo constructor de la pieza
     * 
     * @param nombre
     * @param color
     * @param posicion
     */
    public Pieza(String nombre, Tipo tipoPieza, Casilla posicion) {
        this.nombre = nombre;
        this.tipoPieza = tipoPieza;
        this.posicion = posicion;
        this.iconoRuta = "src/main/java/piezas/aspectos/" + nombre + "-" + tipoPieza.toString() + ".png";
    }

    /**
     * Método abstracto pieza define sus movimientos válidos
     * 
     * @param grafo
     * @return
     */
    public abstract List<Movimiento> calcularMovimientosValidos(Tablero grafo);

    // Método común para validar casillas
    protected boolean esCasillaValida(int row, int col, Tablero grafo) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    // Getters y setters
    public Casilla getPosicion() {
        return posicion;
    }

    public Tipo getColor() {
        return tipoPieza;
    }

    public String getIconoRuta() {
        return iconoRuta;
    }

    public String getNombre() {
        return nombre;
    }

}
