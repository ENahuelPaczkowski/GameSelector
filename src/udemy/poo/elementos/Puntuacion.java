/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udemy.poo.elementos;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JPanel;
import udemy.poo.interfaz.Actions;
import udemy.poo.modelo.Burbuja;

/**
 *
 * @author Eduardo Nahuel Paczkowski
 */
public class Puntuacion implements Actions {

    private JPanel panel;
    private int nave = 0;
    private int orbe = 0;

    public Puntuacion(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void pintar(Graphics2D g) {

        g.setFont(new Font("Time New Roman", Font.PLAIN, 20));
        g.drawString("Nave: " + nave, 0, 20);
        g.drawString("Orbe: " + nave, 700, 20);
    }

    @Override
    public void teclado(KeyEvent e) {
    }

    @Override
    public void raton(MouseEvent e) {
    }

    @Override
    public void calculo() {

        Burbujas burbujas = Burbujas.getBurbujas();

        if (burbujas.getElementos().size() > 1) {

            for (Burbuja elemento : burbujas.getElementos()) {

                if (elemento.getWhoDeleted().equalsIgnoreCase("nave")) {
                    nave += 1;
                } else if (elemento.getWhoDeleted().equalsIgnoreCase("orbe")) {
                    orbe += 1;
                }
            }

            Iterator iterator = burbujas.getElementos().iterator();

            while (iterator.hasNext()) {

                Burbuja objeto = (Burbuja) iterator.next();

                if (objeto.isEliminar()) {
                    iterator.remove();
                }
            }
        } else {
            burbujas.configurar(this.panel, "orbe.png");
        }
    }

}
