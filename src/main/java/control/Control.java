package control;

import objetos.Color;
import objetos.Tablero;
import piezas.*;

public class Control {
    Tablero tablero;

    /**
     * Constructor del tablero
     */
    public Control(){
        this.tablero = new Tablero();
    }

    /**
     * posiciona las piezas por defecto
     */
    public void iniciarJuego() {
        //agregacion de las piezas negras
        tablero.getSquare(7, 0).piece = new Torre(Color.NEGRO, tablero.getSquare(7, 0));
        tablero.getSquare(7, 1).piece = new Caballo(Color.NEGRO, tablero.getSquare(7, 1));
        tablero.getSquare(7, 2).piece = new Alfil(Color.NEGRO, tablero.getSquare(7, 2));
        tablero.getSquare(7, 3).piece = new Reina(Color.NEGRO, tablero.getSquare(7, 3));
        tablero.getSquare(7, 4).piece = new Rey(Color.NEGRO, tablero.getSquare(7, 4));
        tablero.getSquare(7, 5).piece = new Alfil(Color.NEGRO, tablero.getSquare(7, 5));
        tablero.getSquare(7, 6).piece = new Caballo(Color.NEGRO, tablero.getSquare(7, 6));
        tablero.getSquare(7, 7).piece = new Torre(Color.NEGRO, tablero.getSquare(7, 7));
        for (int col = 0; col < 8; col++) {
            tablero.getSquare(6, col).piece = new Peon(Color.NEGRO, tablero.getSquare(6, col));
        }

        // agregacion de las piezas blancas
        tablero.getSquare(0, 0).piece = new Torre(Color.BLANCO, tablero.getSquare(0, 0));
        tablero.getSquare(0, 1).piece = new Caballo(Color.BLANCO, tablero.getSquare(0, 1));
        tablero.getSquare(0, 2).piece = new Alfil(Color.BLANCO, tablero.getSquare(0, 2));
        tablero.getSquare(0, 3).piece = new Reina(Color.BLANCO, tablero.getSquare(0, 3));
        tablero.getSquare(0, 4).piece = new Rey(Color.BLANCO, tablero.getSquare(0, 4));
        tablero.getSquare(0, 5).piece = new Alfil(Color.BLANCO, tablero.getSquare(0, 5));
        tablero.getSquare(0, 6).piece = new Caballo(Color.BLANCO, tablero.getSquare(0, 6));
        tablero.getSquare(0, 7).piece = new Torre(Color.BLANCO, tablero.getSquare(0, 7));
        for (int col = 0; col < 8; col++) {
            tablero.getSquare(1, col).piece = new Peon(Color.BLANCO, tablero.getSquare(1, col));
        }
    }

    public Tablero getTablero(){
        return this.tablero;
    }
}
