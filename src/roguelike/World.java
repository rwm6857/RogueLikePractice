package roguelike;

import java.awt.Color;

/**
 * Creates the world and gives access to it's attributes
 *
 * @author rwm6857
 */
public class World {
    /**
     * 2D array for storing tiles
     */
    private Tile[][] tiles;
    /**
     * width of world
     */
    private int width;
    /**
     * height of world
     */
    private int height;

    /**
     * constructor for the World
     *
     * @param tiles 2D array of various tiles
     */
    public World(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    /**
     * gives width of world
     *
     * @return width
     */
    public int width() {
        return width;
    }

    /**
     * gives height of world
     *
     * @return height
     */
    public int height() {
        return height;
    }

    /**
     * checks for bounds
     *
     * @param x horizontal position
     * @param y vertical position
     * @return either returns BOUNDS or the tile at x and y
     */
    public Tile tile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }

    /**
     * gets the glyph at the current position
     *
     * @param x horizontal position
     * @param y vertical position
     * @return glyph at (x,y)
     */
    public char glyph(int x, int y) {
        return tile(x, y).glyph();
    }

    /**
     * gets the color at the current position
     *
     * @param x horizontal position
     * @param y vertical position
     * @return color at (x,y)
     */
    public Color color(int x, int y) {
        return tile(x, y).color();
    }
}

