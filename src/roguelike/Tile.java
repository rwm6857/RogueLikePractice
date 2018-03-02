package roguelike;

import java.awt.Color;

import asciiPanel.AsciiPanel;

/**
 * enum used to make tiles from floors, walls, and bounds
 *
 * @author rwm6857
 */
public enum Tile {
    FLOOR((char) 250, AsciiPanel.yellow),
    WALL((char) 177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack);

    /**
     * glyph character attribute
     */
    private char glyph;

    /**
     * glyph method that returns the attribute
     *
     * @return glyph character
     */
    public char glyph() {
        return glyph;
    }

    /**
     * color attribute
     */
    private Color color;

    /**
     * returns the color class
     *
     * @return color
     */
    public Color color() {
        return color;
    }

    /**
     * constructs a tile
     *
     * @param glyph glyph character
     * @param color color
     */
    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }

    /**
     * checks if a wall is diggable
     *
     * @return true if tile is a WALL, false otherwise
     */
    public boolean isDiggable() {
        return this == Tile.WALL;
    }
}
