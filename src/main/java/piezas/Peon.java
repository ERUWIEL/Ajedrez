package piezas;

import java.util.ArrayList;
import java.util.List;

import objetos.Casilla;
import objetos.Color;
import objetos.Movimiento;
import objetos.Tablero;

/**
 *
 * @author angel
 */
public class Peon extends Pieza {

    private boolean primerMovimiento = true;

    public Peon(Color color, Casilla posicion) {
        super("Peón", color, posicion);
    }

    @Override
    public List<Movimiento> calcularMovimientosValidos(Tablero grafo) {
        List<Movimiento> movimientos = new ArrayList<>();
        int direccion = (this.color == Color.BLANCO) ? -1 : 1; // Blancos avanzan hacia filas menores, negros hacia mayores

        // Movimiento hacia adelante (1 o 2 casillas)
        int newRow = posicion.row + direccion;
        if (esCasillaValida(newRow, posicion.col, grafo)) {
            Casilla destino = grafo.getSquare(newRow, posicion.col);
            if (destino.piece == null) {
                movimientos.add(new Movimiento(posicion, destino));
                // Primer movimiento: avance doble
                if (primerMovimiento) {
                    newRow += direccion;
                    destino = grafo.getSquare(newRow, posicion.col);
                    if (destino.piece == null) {
                        movimientos.add(new Movimiento(posicion, destino));
                    }
                }
            }
        }

        // Capturas en diagonal
        int[] columnasCaptura = {posicion.col - 1, posicion.col + 1};
        for (int col : columnasCaptura) {
            newRow = posicion.row + direccion;
            if (esCasillaValida(newRow, col, grafo)) {
                Casilla destino = grafo.getSquare(newRow, col);
                if (destino.piece != null && destino.piece.color != this.color) {
                    movimientos.add(new Movimiento(posicion, destino));
                }
            }
        }
        return movimientos;
    }

    public void setPrimerMovimiento(boolean estado) {
        this.primerMovimiento = estado;
    }
}
