package roguelike.screens;

import asciiPanel.AsciiPanel;
import roguelike.creatures.Creature;
import roguelike.creatures.CreatureFactory;
import roguelike.world.World;
import roguelike.world.WorldBuilder;

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
    private int screenWidth;
    /**
     * height of the screen
     */
    private int screenHeight;
    /**
     * player for the game
     */
    private Creature player;

    /**
     * constructor for a PlayScreen
     */
    public PlayScreen() {
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
        CreatureFactory creatureFactory = new CreatureFactory(world);
        player = creatureFactory.newPlayer();
    }

    /**
     * creates a new World using the World builder
     */
    private void createWorld() {
        world = new WorldBuilder(90, 31).makeCaves().build();
    }

    /**
     * displays tiles on the terminal
     *
     * @param terminal terminal window
     * @param left     left most position
     * @param top      top most position
     */
    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;

                Creature creature = world.creature(wx, wy);
                if (creature != null)
                    terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());
                else
                    terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
            }
        }
    }

    /**
     * displays gameplay on the terminal
     *
     * @param terminal the AsciiPanel to deliver output
     */
    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top);
        terminal.write(player.glyph(), player.x - left, player.y - top, player.color());

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
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H:
                player.moveBy(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L:
                player.moveBy(1, 0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K:
                player.moveBy(0, -1);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J:
                player.moveBy(0, 1);
                break;
            case KeyEvent.VK_Y:
                player.moveBy(-1, -1);
                break;
            case KeyEvent.VK_U:
                player.moveBy(1, -1);
                break;
            case KeyEvent.VK_B:
                player.moveBy(-1, 1);
                break;
            case KeyEvent.VK_N:
                player.moveBy(1, 1);
                break;
        }
        return this;
    }

    /**
     * limits how far we can scroll in x
     *
     * @return maximum x value
     */
    public int getScrollX() {
        return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
    }

    /**
     * limits how far we can scroll in y
     *
     * @return maximum y value
     */
    public int getScrollY() {
        return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight));
    }
}