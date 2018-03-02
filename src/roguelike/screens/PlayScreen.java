package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

/**
 * Shows dungeon, inhabitants, and loot
 * Responds to player input by moving
 * Sets in "win" or "lose" mode as necessary
 *
 * @author rwm6857
 */
public class PlayScreen implements Screen {
    /**
     * displays gameplay on the terminal
     *
     * @param terminal the AsciiPanel to deliver output
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You are having fun.", 1, 1);
        terminal.writeCenter(" ~~ press [ESC] to lose or [ENTER] to win ~~", 22);
    }

    /**
     * lose if the user hits escape, win if the user hits enter
     *
     * @param key value that triggers an event
     * @return WinScreen or LoseScreen
     */
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return new LoseScreen();
            case KeyEvent.VK_ENTER:
                return new WinScreen();
        }
        return this;
    }
}
