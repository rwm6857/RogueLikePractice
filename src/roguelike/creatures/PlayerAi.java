package roguelike.creatures;

import roguelike.world.Tile;

import java.util.List;

/**
 * creates the AI for the active player
 *
 * @author rwm6857
 */
public class PlayerAi extends CreatureAi {
    /**
     * collection of messages
     */
    private List<String> messages;

    /**
     * constructor for the PlayerAI
     *
     * @param creature creature controlled by AI
     */
    public PlayerAi(Creature creature, List<String> messages) {
        super(creature);
        this.messages = messages;
    }

    /**
     * adds message to message queue
     *
     * @param message message to be displayed
     */
    public void onNotify(String message) {
        messages.add(message);
    }

    /**
     * allows the player to move and dig
     *
     * @param x    x position
     * @param y    y position
     * @param tile current tile position
     */
    @Override
    public void onEnter(int x, int y, Tile tile) {
        if (tile.isGround()) {
            creature.x = x;
            creature.y = y;
        } else if (tile.isDiggable()) {
            creature.dig(x, y);
        }
    }
}
