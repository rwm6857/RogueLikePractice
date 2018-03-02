package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

/**
 * Screen shows the user that they have won
 * Asks user if they would like to play again
 *
 * @author rwm6857
 */
public class WinScreen implements Screen {
    /**
     * displays win message and asks user if they want to replay
     *
     * @param terminal the AsciiPanel to deliver output
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You won.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    /**
     * restarts the game if the user its enter
     *
     * @param key value that triggers an event
     * @return new play screen
     */
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
