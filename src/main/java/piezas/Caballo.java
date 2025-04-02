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
public class Caballo extends Pieza {
    /**
     * Constructor del caballo
     * @param color
     * @param posicion 
     */
    public Caballo(Color color, Casilla posicion) {
        super("Caballo", color, posicion);
    }
    
    /**
     * implementacion del metodo abstracto de movimiento
     * @param grafo
     * @return 
     */
    @Override
    public List<Movimiento> calcularMovimientosValidos(Tablero grafo) {
        List<Movimiento> movimientos = new ArrayList<>();
        // posibles movimientos (x,y)
        int[][] saltos = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        for (int[] salto : saltos) {
            int newRow = posicion.row + salto[0];
            int newCol = posicion.col + salto[1];
            if (esCasillaValida(newRow, newCol, grafo)) {
                Casilla destino = grafo.getSquare(newRow, newCol);
                if (destino.piece == null || destino.piece.color != this.color) {
                    movimientos.add(new Movimiento(posicion, destino));
                }
            }
        }
        return movimientos;
    }
}
