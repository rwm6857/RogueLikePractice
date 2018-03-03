package roguelike.creatures;

import asciiPanel.AsciiPanel;
import roguelike.world.World;

/**
 * creates all the creatures for a world
 *
 * @author rwm6857
 */
public class CreatureFactory {
    /**
     * world creatures are created in
     */
    private World world;

    /**
     * constructor for CreatureFactory
     *
     * @param world world creatures are created in
     */
    public CreatureFactory(World world) {
        this.world = world;
    }

    /**
     * creates the player
     *
     * @return new player
     */
    public Creature newPlayer() {
        Creature player = new Creature(world, '@', AsciiPanel.brightWhite);
        world.addAtEmptyLocation(player);
        new PlayerAi(player);
        return player;
    }
}
