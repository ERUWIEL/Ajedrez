package normas;

import tablero.Casilla;

/**
 *
 * @author erwbyel
 */
public class Movimiento {
    public Casilla from;
    public Casilla to;

    public Movimiento(Casilla from, Casilla to) {
        this.from = from;
        this.to = to;
    }
}
