package piezas;

import java.util.List;

import objetos.Casilla;
import objetos.Color;
import objetos.Movimiento;
import objetos.Tablero;

/**
 * Clase padre que modela las piezas de ajedrez
 * @author erwbiel
 */
public abstract class Pieza {

    protected String nombre;
    protected Color color;
    protected Casilla posicion; // Casilla actual

    /**
     * Metodo constructor de la pieza
     * @param nombre
     * @param color
     * @param posicion 
     */
    public Pieza(String nombre, Color color, Casilla posicion) {
        this.nombre = nombre;
        this.color = color;
        this.posicion = posicion;
    }

    /**
     * Método abstracto pieza define sus movimientos válidos
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

    public Color getColor() {
        return color;
    }
}
