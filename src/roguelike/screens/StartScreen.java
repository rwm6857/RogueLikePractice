package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

/**
 * Provides the starting screen for the game
 * Puts user in "play mode" after hitting enter
 */
public class StartScreen implements Screen {
    /**
     * Prints the opening message for the StartScreen
     *
     * @param terminal the AsciiPanel to deliver output
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("RogueLike Tutorial", 1, 1);
        terminal.writeCenter("~~ Press [ENTER] to start ~~", 22);
    }

    /**
     * Invokes the PlayScreen when the user hits enter
     *
     * @param key value that triggers an event
     * @return a new PlayScreen
     */
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
