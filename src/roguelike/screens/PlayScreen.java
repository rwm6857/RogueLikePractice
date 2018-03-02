package roguelike.screens;

import asciiPanel.AsciiPanel;
import roguelike.World;
import roguelike.WorldBuilder;

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
     * generated world
     */
    private World world;
    /**
     * center of the screen horizontally
     */
    private int centerX;
    /**
     * center of the screen vertically
     */
    private int centerY;
    /**
     * width of the screen
     */
    private int screenWidth;
    /**
     * height of the sceen
     */
    private int screenHeight;

    /**
     * constructor for a PlayScreen
     */
    public PlayScreen() {
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
    }

    /**
     * creates a new World using the World builder
     */
    private void createWorld() {
        world = new WorldBuilder(90, 31)
                .makeCaves()
                .build();
    }

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
