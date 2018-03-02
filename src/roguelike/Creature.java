package roguelike;

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
    private void setCreatureAi(CreatureAi ai) {
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
}