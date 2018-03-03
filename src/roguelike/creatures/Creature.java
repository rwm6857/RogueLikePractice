package roguelike.creatures;

import roguelike.world.World;

import java.awt.Color;

/**
 * used to create and manipulate the game's creatures
 */
public class Creature {
    /**
     * world that the create lives in
     */
    private World world;
    /**
     * creature's glyph
     */
    private char glyph;
    /**
     * creature's color
     */
    private Color color;
    /**
     * the AI that controls a creature
     */
    private CreatureAi ai;
    /**
     * x position
     */
    public int x;
    /**
     * y position
     */
    public int y;

    /**
     * constructor for Creature
     *
     * @param world World the creature lives in
     * @param glyph creature's glyph
     * @param color creature's color
     */
    public Creature(World world, char glyph, Color color) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    /**
     * gets glyph
     *
     * @return creature's glyph
     */
    public char glyph() {
        return this.glyph;
    }

    /**
     * gets color
     *
     * @return creature's color
     */
    public Color color() {
        return this.color;
    }

    /**
     * links a creature to an AI
     *
     * @param ai the AI that controls the creature
     */
    public void setCreatureAi(CreatureAi ai) {
        this.ai = ai;
    }

    /**
     * allows the creature to dig through cave walls
     *
     * @param wx wall x
     * @param wy wall y
     */
    public void dig(int wx, int wy) {
        world.dig(wx, wy);
    }

    /**
     * allows creatures to move in the world dependant on AI
     * if enemy is present, attack
     *
     * @param mx max x
     * @param my max y
     */
    public void moveBy(int mx, int my) {
        Creature other = world.creature(x + mx, y + my);

        if (other == null)
            ai.onEnter(x + mx, y + my, world.tile(x + mx, y + my));
        else
            attack(other);
    }

    /**
     * attack the creature by simply removing it
     *
     * @param other creature being attacked
     */
    public void attack(Creature other) {
        world.remove(other);
    }
}
