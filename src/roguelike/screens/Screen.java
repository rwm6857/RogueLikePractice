package roguelike.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

/**
 * simple interface for various screen modes
 * each screen displays output on AsciiPanel and responds to input
 *
 * @author rwm6857
 */
public interface Screen {
    /**
     * causes output to appear depending on the screen type
     *
     * @param terminal the AsciiPanel to deliver output
     */
    public void displayOutput(AsciiPanel terminal);

    /**
     * invokes a response to input that is attached to a certain screen type
     *
     * @param key value that triggers an event
     * @return screen related to the event
     */
    public Screen respondToUserInput(KeyEvent key);
}
