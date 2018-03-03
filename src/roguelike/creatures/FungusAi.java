package roguelike.creatures;

/**
 * Creates the AI for the stationary fungus
 *
 * @author rwm6857
 */
public class FungusAi extends CreatureAi {
    /**
     * factory controlling this creature's production
     */
    private CreatureFactory factory;
    /**
     * times the fungus has spread
     */
    private int spreadcount;

    /**
     * constructor for the CreatureAI
     *
     * @param creature a creature to link to the fungus AI
     */
    public FungusAi(Creature creature, CreatureFactory factory) {
        super(creature);
        this.factory = factory;
    }

    /**
     * logic for fungus spreading on update
     */
    public void onUpdate() {
        if (spreadcount < 5 && Math.random() < 0.02)
            spread();
    }

    /**
     * enables the fungus to spread across the world
     */
    private void spread() {
        int x = creature.x + (int) (Math.random() * 11) - 5;
        int y = creature.y + (int) (Math.random() * 11) - 5;

        if (!creature.canEnter(x, y))
            return;

        Creature child = factory.newFungus();
        child.x = x;
        child.y = y;
        spreadcount++;
    }
}

