package roguelike;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import asciiPanel.AsciiPanel;
import roguelike.screens.Screen;
import roguelike.screens.StartScreen;

import javax.swing.*;

/**
 * Allows the game to run from users' browser
 *
 * @author rwm6857 (Ryan Moore)
 */
public class AppletMain extends Applet implements KeyListener {
    /**
     * helps to prevent faliues when serializing different class versions
     */
    private static final long serialVersionUID = 2560255315130084198L;
    /**
     * terminal window to display the game info
     */
    private AsciiPanel terminal;
    /**
     * current game screen class
     */
    private Screen screen;

    /**
     * instantiates an AppletMain so the game can be run in a browser
     */
    public AppletMain() {
        super();
        terminal = new AsciiPanel();
        terminal.write("RogueLike Tutorial", 1, 1);
        add(terminal);
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    /**
     * initializes the size of the applet
     */
    public void init() {
        super.init();
        this.setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
    }

    /**
     * used for drawing in the applet window
     */
    public void repaint() {
        super.repaint();
        terminal.repaint();
    }

    /**
     * checks if key is pressed and repaints screen
     *
     * @param e key event code
     */
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    /**
     * checks if key is released
     *
     * @param e key event code
     */
    public void keyReleased(KeyEvent e) {
    }

    /**
     * checks if key is typed
     *
     * @param e key event code
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * main method for AppletMain
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
