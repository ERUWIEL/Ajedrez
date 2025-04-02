package tablero;

import java.util.*;
import normas.Movimiento;

/**
 *
 * @author angel
 */
public class Tablero {

    private List<Casilla> squares;
    private Map<Casilla, List<Movimiento>> adjacencyList;

    public Tablero() {
        squares = new ArrayList<>();
        adjacencyList = new HashMap<>();
        inicializarTablero();
    }

    private void inicializarTablero() {
        // Crear 64 casillas
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares.add(new Casilla(row, col));
            }
        }
    }

    public List<Movimiento> getMovimientosValidos(Casilla casilla) {
        return adjacencyList.getOrDefault(casilla, new ArrayList<>());
    }

    public Casilla getSquare(int row, int col) {
        return squares.get(row * 8 + col);
    }
}
