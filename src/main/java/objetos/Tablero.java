package objetos;

import java.util.*;

/**
 *
 * @author angel
 */
public class Tablero {

    private List<Casilla> cuadros;
    private Map<Casilla, List<Movimiento>> adjacencyList;

    /**
     * Metodo constructor del tablero
     */
    public Tablero() {
        cuadros = new ArrayList<>();
        adjacencyList = new HashMap<>();
        inicializarTablero();
    }
    /**
     * Metodo para crear los recuadros intercalados
     */
    private void inicializarTablero() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Color color = (row + col) % 2 == 0 ? Color.NEGRO : Color.BLANCO;
                cuadros.add(new Casilla(row, col, color));
            }
        }
    }

    public List<Movimiento> getMovimientosValidos(Casilla casilla) {
        return adjacencyList.getOrDefault(casilla, new ArrayList<>());
    }

    public Casilla getSquare(int row, int col) {
        return cuadros.get(row * 8 + col);
    }
}
