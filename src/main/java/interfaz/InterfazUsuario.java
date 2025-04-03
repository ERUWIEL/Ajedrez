package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Control;
import objetos.Movimiento;
import objetos.Tablero;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.util.List;

public class InterfazUsuario extends JFrame{
    /**
     * MetodoConstructor
     */
    public InterfazUsuario(){
        setSize(700, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponents();
    }

    /**
     * Metodo para iniciar los componentes dela ventana
     */
    private void initComponents(){
        //Panel superior
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl = new JLabel("AJEDREZ DEL PIRATA");
        pnl.add(lbl);
        add(pnl,BorderLayout.NORTH);
        
        //Panel central
        //JPanel tablero = new JPanel(new GridLayout(8,8));
        
    }

    /**
     * Metodo para iniciar la ventana de usuario
     * @param args
     */
    public static void main(String[] args) {
        //new InterfazUsuario().setVisible(true);
        Control ct = new Control();
        ct.iniciarJuego();
        Tablero tablero = ct.getTablero();

        List<Movimiento> movi = tablero.getSquare(7, 2).piece.calcularMovimientosValidos(tablero);
        for (Movimiento move : movi){
            System.out.printf("De (%d,%d) a (%d,%d)\n",move.from.row, move.from.col,move.to.row, move.to.col);
        }
    }

}
