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

    /**
     * randomizes tiles in height and width using Cellular Automata
     *
     * @return randomized tiles
     */
    private WorldBuilder randomizeTiles() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

    /**
     * smooths out the randomized tiles using Cellular Automata smoothing
     *
     * @param times number of smoothing passes
     * @return randomized, smooth tiles
     */
    private WorldBuilder smooth(int times) {
        Tile[][] tiles2 = new Tile[width][height];
        for (int time = 0; time < times; time++) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int floors = 0;
                    int rocks = 0;
                    for (int ox = -1; ox < 2; ox++) {
                        for (int oy = -1; oy < 2; oy++) {
                            if (x + ox < 0 || x + ox >= width || y + oy < 0
                                    || y + oy >= height)
                                continue;
                            if (tiles[x + ox][y + oy] == Tile.FLOOR)
                                floors++;
                            else
                                rocks++;
                        }
                    }
                    tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = tiles2;
        }
        return this;
    }
}
