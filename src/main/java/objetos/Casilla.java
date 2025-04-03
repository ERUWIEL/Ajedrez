package objetos;

import piezas.Pieza;

/**
 * 
 * @author erwbyel
 */
public class Casilla {
    public int row;
    public int col;
    public Pieza piece;
    public Color color;

    public Casilla(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
}
