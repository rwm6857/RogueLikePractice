package roguelike;

import java.applet.Applet;

import asciiPanel.AsciiPanel;

/**
 * Allows the game to run from users' browser
 *
 * @author rwm6857 (Ryan Moore)
 */
public class AppletMain extends Applet {
    /**
     * helps to prevent faliues when serializing different class versions
     */
    private static final long serialVersionUID = 2560255315130084198L;
    /**
     * terminal window to display the game info
     */
    private AsciiPanel terminal;

    /**
     * instantiates an AppletMain so the game can be run in a browser
     */
    public AppletMain() {
        super();
        terminal = new AsciiPanel();
        terminal.write("RogueLike Tutorial", 1, 1);
        add(terminal);
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


}
