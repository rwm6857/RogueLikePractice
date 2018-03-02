package roguelike;

/**
 * Actually builds the world that is used by the World class
 *
 * @author rwm6857
 */
public class WorldBuilder {
    /**
     * world width
     */
    private int width;
    /**
     * world height
     */
    private int height;
    /**
     * 2D array of tiles
     */
    private Tile[][] tiles;

    /**
     * constructor for the WorlBuilder
     *
     * @param width  width of the world
     * @param height height of the world
     */
    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    /**
     * builds the world
     *
     * @return new World
     */
    public World build() {
        return new World(tiles);
    }
}
