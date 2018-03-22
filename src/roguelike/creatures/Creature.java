package roguelike.creatures;

import roguelike.world.World;
import roguelike.creatures.PlayerAi;

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
     * hit points
     */
    private int hp;
    /**
     * max hit points
     */
    private int maxHp;
    /**
     * attack power
     */
    private int attackValue;
    /**
     * defense points
     */
    private int defenseValue;

    /**
     * constructor for Creature
     *
     * @param world World the creature lives in
     * @param glyph creature's glyph
     * @param color creature's color
     */
    public Creature(World world, char glyph, Color color, int maxHp, int attack, int defense) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackValue = attack;
        this.defenseValue = defense;
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
     * attack the creature by calculating damage and removing it if <1
     *
     * @param other creature being attacked
     */
    public void attack(Creature other) {
        int amount = Math.max(0, attackValue() - other.defenseValue());
        amount = (int) (Math.random() * amount) + 1;
        other.modifyHp(-amount);
        notify("You attack the '%s' for %d damage.", other.glyph, amount);
        other.notify("The '%s' attacks you for %d damage.", glyph, amount);
    }

    /**
     * modifies the hit points of a Creature
     *
     * @param amount
     */
    public void modifyHp(int amount) {
        hp += amount;
        if (hp < 1) {
            this.world.remove(this);
        }
    }

    /**
     * get max hp
     *
     * @return maxHp
     */
    public int maxHp() {
        return this.maxHp;
    }

    /**
     * get current hp
     *
     * @return hp
     */
    public int hp() {
        return this.hp;
    }

    /**
     * get attack power
     *
     * @return attack value
     */
    public int attackValue() {
        return this.attackValue;
    }

    /**
     * get defense points
     *
     * @return defense value
     */
    public int defenseValue() {
        return this.defenseValue;
    }

    /**
     * invokes the AI to update
     */
    public void update() {
        ai.onUpdate();
    }

    /**
     * checks if player can enter tile
     * @param wx x position
     * @param wy y position
     * @return true if clear, otherwise false
     */
    public boolean canEnter(int wx, int wy) {
        return world.tile(wx, wy).isGround() && world.creature(wx, wy) == null;
    }

    /**
     * used to handle messages to PlayerAi
     * @param message message to be sent
     * @param params any object
     */
    public void notify(String message, Object ... params){
        ai.onNotify(message);
    }
}
