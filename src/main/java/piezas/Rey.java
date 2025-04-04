package piezas;

import java.util.ArrayList;
import java.util.List;

import objetos.Casilla;
import objetos.Movimiento;
import objetos.Tablero;

/**
 *
 * @author angel
 */
public class Rey extends Pieza {

    public Rey(Tipo tipoPieza, Casilla posicion) {
        super("Rey", tipoPieza, posicion);
    }

    @Override
    public List<Movimiento> calcularMovimientosValidos(Tablero grafo) {
        List<Movimiento> movimientos = new ArrayList<>();
        int[][] direcciones = {{-1, -1}, {-1, 0}, {-1, 1},{0, -1}, {0, 1},{1, -1}, {1, 0}, {1, 1}};

        for (int[] dir : direcciones) {
            int row = posicion.row + dir[0];
            int col = posicion.col + dir[1];
            if (esCasillaValida(row, col, grafo)) {
                Casilla destino = grafo.getSquare(row, col);
                if (destino.piece == null || destino.piece.tipoPieza != this.tipoPieza) {
                    movimientos.add(new Movimiento(posicion, destino));
                }
            }
        }
        return movimientos;
    }
}
