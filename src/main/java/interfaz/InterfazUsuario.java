package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Control;
import objetos.Casilla;
import objetos.Movimiento;
import objetos.Tablero;
import piezas.Tipo;
import piezas.Torre;

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
        setTitle("(PIRATA VS MENCHO) THE FINAL BATTLE!");
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
        Control ct = new Control();
        ct.iniciarJuego();
        JPanel tablero = ct.dibujaTablero();
        add(tablero, BorderLayout.CENTER);
    }

    /**
     * Metodo para iniciar la ventana de usuario
     * @param args
     */
    public static void main(String[] args) {
        new InterfazUsuario().setVisible(true);
    }

}
