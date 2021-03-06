/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udemy.poo.elementos;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import static java.lang.reflect.Array.get;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.get;
import udemy.poo.interfaz.Actions;

/**
 *
 * @author Eduardo Nahuel Paczkowski
 */
public class ImagenFondoGameN implements Actions {

    private Image imagen = null;
    private Image imagenDos = null;
    private Component componente;
    private int x = -20;
    private static ImagenFondoGameN objetoUnico;
    private MediaTracker tracker;

    public static ImagenFondoGameN imagenFondo() {

        if (objetoUnico == null) {
            objetoUnico = new ImagenFondoGameN();
        }
        return objetoUnico;
    }

    private ImagenFondoGameN() {
    }

    public void configuracion(Component componente, String archivo, String personaje) {

        this.componente = componente;
        tracker = new MediaTracker(componente);
        Toolkit herram = Toolkit.getDefaultToolkit();
        imagen = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + archivo));
        imagenDos = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + personaje));
        tracker.addImage(imagen, 1);
        tracker.addImage(imagenDos, 2);
        
        // Espera a que todas la imagenes sean cargadas
        try {
            tracker.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void pintar(Graphics2D g) {
        
        g.drawImage(imagen, 0, 0, this.componente.getWidth(), this.componente.getHeight(), null);
        g.drawImage(imagenDos, x + 800, 40, 300, 368, null);
    }

    @Override
    public void teclado(KeyEvent e) {
    }

    @Override
    public void raton(MouseEvent e) {
    }

    @Override
    public void calculo() {
    }

}
