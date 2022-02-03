/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package udemy.poo.interfaz;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Eduardo Nahuel Paczkowski
 */
public interface Actions {
    
    public void pintar(Graphics2D g);
    
    public void teclado(KeyEvent e);
    
    public void raton(MouseEvent e);
    
    public void calculo();
}
