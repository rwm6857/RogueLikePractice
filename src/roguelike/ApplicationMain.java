package roguelike;

import javax.swing.JFrame;

import asciiPanel.AsciiPanel;
import roguelike.screens.Screen;
import roguelike.screens.StartScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Main application class for my first RogueLike, following a tutorial
 * http://trystans.blogspot.com/2016/01/roguelike-tutorial-00-table-of-contents.html
 * by trystan.
 * <p>
 * This game is build using Maven 3, and utilized JFrame and AsciiPanel by trysan
 * to display as an ascii terminal using code page 437. Ascii Panel repository:
 * https://github.com/trystan/AsciiPanel
 *
 * @author rwm6857 (Ryan Moore)
 */
public class ApplicationMain extends JFrame implements KeyListener {
    /**
     * helps to prevent faliues when serializing different class versions
     */
    private static final long serialVersionUID = 1060623638149583738L;
    /**
     * terminal window to display the game info
     */
    private AsciiPanel terminal;
    /**
     * the Screen currently being displayed
     */
    private Screen screen;

    /**
     * creates the ApplicationMain window
     */
    public ApplicationMain() {
        super();
        terminal = new AsciiPanel();
        terminal.write("RogueLike Tutorial", 1, 1);
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    /**
     * rebuilds the terminal window
     */
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    /**
     * checks if a key is pressed and repaints the screen
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
     * checks if a key is typed
     *
     * @param e key event code
     */
    public void keyTyped(KeyEvent e) {
    }


    /**
     * main function, instantiates ApplicationMean and delegates input
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
