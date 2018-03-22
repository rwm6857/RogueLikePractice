package roguelike.creatures;

import roguelike.world.Tile;

/**
 * Artificial intelligence for a creature
 */
public class CreatureAi {
    /**
     * Creature controlled by AI
     */
    protected Creature creature;

    /**
     * constructor for the CreatureAI
     *
     * @param creature
     */
    public CreatureAi(Creature creature) {
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }

    /**
     * creature moves and digs
     *
     * @param x    x position
     * @param y    y position
     * @param tile current tile position
     */
    public void onEnter(int x, int y, Tile tile) {
    }

    /**
     * used to update the AI
     */
    public void onUpdate() {
    }

    /**
     * used to update messages
     * @param message string to be added
     */
    public void onNotify(String message) {
    }
}
