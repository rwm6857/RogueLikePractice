package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

/**
 * Displays the losing screen and asks user if they would like to play again
 *
 * @author rwm6857
 */
public class LoseScreen implements Screen {
    /**
     * displays the lose messages and asks user to replay
     *
     * @param terminal the AsciiPanel to deliver output
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You lost.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    /**
     * restarts if the user hits enter
     *
     * @param key value that triggers an event
     * @return new PlayScreen
     */
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
