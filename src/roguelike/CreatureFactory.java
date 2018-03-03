package roguelike;

import asciiPanel.AsciiPanel;

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
