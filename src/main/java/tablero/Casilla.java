package tablero;

import piezas.Pieza;

/**
 * 
 * @author erwbyel
 */
public class Casilla {
    public int row;
    public int col;
    public Pieza piece;

    public Casilla(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
