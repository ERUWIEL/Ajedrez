
package piezas;

import java.util.ArrayList;
import java.util.List;
import normas.Color;
import normas.Movimiento;
import tablero.Casilla;
import tablero.Tablero;

/**
 *
 * @author angel
 */
public class Torre extends Pieza{

    public Torre(Color color, Casilla posicion) {
        super("Torre", color, posicion);
    }
    
    @Override
    public List<Movimiento> calcularMovimientosValidos(Tablero grafo) {
        List<Movimiento> movimientos = new ArrayList<>();
        int[][] direcciones = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int[] dir : direcciones) {
            int row = posicion.row + dir[0];
            int col = posicion.col + dir[1];
            while (esCasillaValida(row, col, grafo)) {
                Casilla destino = grafo.getSquare(row, col);
                if (destino.piece == null) {
                    movimientos.add(new Movimiento(posicion, destino));
                } else {
                    if (destino.piece.color != this.color) {
                        movimientos.add(new Movimiento(posicion, destino));
                    }
                    break; // Pieza bloqueando
                }
                row += dir[0];
                col += dir[1];
            }
        }
        return movimientos;
    }
}
