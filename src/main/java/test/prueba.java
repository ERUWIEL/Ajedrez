package test;

import java.util.List;
import normas.Color;
import normas.Movimiento;
import piezas.Alfil;
import piezas.Caballo;
import piezas.Peon;
import piezas.Reina;
import piezas.Rey;
import piezas.Torre;
import tablero.Casilla;
import tablero.Tablero;

/**
 *
 * @author angel
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero g = new Tablero();
        
        

        // Colocar un caballo blanco en 4,3
        Casilla a1 = g.getSquare(5, 5);
        Caballo caballo = new Caballo(Color.BLANCO, a1);
        a1.piece = caballo;
        
        // COlocar un Peon blanco en 4,4
        Casilla d4 = g.getSquare(4, 4);
        Peon peon = new Peon(Color.NEGRO,d4);
        d4.piece = peon;
        
        
        List<Movimiento> movimientosTorre = peon.calcularMovimientosValidos(g);
        for (Movimiento move : movimientosTorre) {
            System.out.printf("De (%d,%d) a (%d,%d)\n", move.from.row, move.from.col, move.to.row, move.to.col);
        }
        //este comentario lo hago desde mi pc para github!
    }

}
