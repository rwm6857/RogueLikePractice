package roguelike;

import javax.swing.JFrame;

import asciiPanel.AsciiPanel;

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
public class ApplicationMain extends JFrame {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;

    public ApplicationMain() {
        super();
        terminal = new AsciiPanel();
        terminal.write("RogueLike Tutorial", 1, 1);
        add(terminal);
        pack();
    }

    public static void main(String[] arg) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
