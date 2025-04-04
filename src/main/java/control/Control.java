package control;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;


import objetos.Casilla;
import objetos.Tablero;
import piezas.*;

public class Control {
    Tablero tablero;

    /**
     * Constructor del tablero
     */
    public Control() {
        this.tablero = new Tablero();
    }

    /**
     * posiciona las piezas por defecto
     */
    public void iniciarJuego() {
        // agregacion de las piezas negras
        tablero.getSquare(7, 0).piece = new Torre(Tipo.NEGRO, tablero.getSquare(7, 0));
        tablero.getSquare(7, 1).piece = new Caballo(Tipo.NEGRO, tablero.getSquare(7, 1));
        tablero.getSquare(7, 2).piece = new Alfil(Tipo.NEGRO, tablero.getSquare(7, 2));
        tablero.getSquare(7, 3).piece = new Reina(Tipo.NEGRO, tablero.getSquare(7, 3));
        tablero.getSquare(7, 4).piece = new Rey(Tipo.NEGRO, tablero.getSquare(7, 4));
        tablero.getSquare(7, 5).piece = new Alfil(Tipo.NEGRO, tablero.getSquare(7, 5));
        tablero.getSquare(7, 6).piece = new Caballo(Tipo.NEGRO, tablero.getSquare(7, 6));
        tablero.getSquare(7, 7).piece = new Torre(Tipo.NEGRO, tablero.getSquare(7, 7));
        for (int col = 0; col < 8; col++) {
            tablero.getSquare(6, col).piece = new Peon(Tipo.NEGRO, tablero.getSquare(6, col));
        }

        // agregacion de las piezas blancas
        tablero.getSquare(0, 0).piece = new Torre(Tipo.BLANCO, tablero.getSquare(0, 0));
        tablero.getSquare(0, 1).piece = new Caballo(Tipo.BLANCO, tablero.getSquare(0, 1));
        tablero.getSquare(0, 2).piece = new Alfil(Tipo.BLANCO, tablero.getSquare(0, 2));
        tablero.getSquare(0, 3).piece = new Reina(Tipo.BLANCO, tablero.getSquare(0, 3));
        tablero.getSquare(0, 4).piece = new Rey(Tipo.BLANCO, tablero.getSquare(0, 4));
        tablero.getSquare(0, 5).piece = new Alfil(Tipo.BLANCO, tablero.getSquare(0, 5));
        tablero.getSquare(0, 6).piece = new Caballo(Tipo.BLANCO, tablero.getSquare(0, 6));
        tablero.getSquare(0, 7).piece = new Torre(Tipo.BLANCO, tablero.getSquare(0, 7));
        for (int col = 0; col < 8; col++) {
            tablero.getSquare(1, col).piece = new Peon(Tipo.BLANCO, tablero.getSquare(1, col));
        }
        System.out.println("set game: done");
    }

    public Tablero getTablero() {
        return tablero;
    }

    public JPanel dibujaTablero() {
        int filas = 8;
        int columnas = 8;
        JPanel pnlTablero = new JPanel(new GridLayout(filas, columnas));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casilla casilla = tablero.getSquare(i, j);
                JPanel bloque = new JPanel(new BorderLayout()); // diseño de la casilla
                bloque.setBackground(casilla.color);
                bloque.setPreferredSize(new Dimension(50, 50));

                if (casilla.piece != null) { // diseño de la pieza en caso de haberla
                    String rutaImagen = casilla.piece.getIconoRuta();
                    ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
                    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    JButton btnPieza = new JButton(new ImageIcon(imagenEscalada));
                    btnPieza.setContentAreaFilled(false);  // Elimina el fondo gris
                    //btnPieza.setBorderPainted(false);      // Quita el borde
                    btnPieza.setFocusPainted(false);       // Elimina el recuadro de enfoque
                    btnPieza.setOpaque(false);             // Hace el botón transparente
                    bloque.add(btnPieza, BorderLayout.CENTER);
                }
                pnlTablero.add(bloque);
            }
        }
        System.out.println("table building : done");
        return pnlTablero;
    }
}
