package roguelike;

import java.awt.Color;

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
}

