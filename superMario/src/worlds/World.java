package worlds;

import handler.Handler;
import tiles.Tile;
import utils.Utils;

import java.awt.*;

public class World
{
    private Handler handler;
    private int width, height;
    private int spawnx, spawny;

    // Holds id's saying which tile should be rendered in which position.
    private int[][] tiles;

    // Load world from a file.
    public World(Handler handler, String path)
    {
        this.handler = handler;
        loadWorld(path);
    }

    public void tick()
    {

    }

    // Render every tile to the screen.
    public void render(Graphics g)
    {
        // Render efficiency

        // check if 0 is greater or less than offset in tiles in x - direction.
        // handler.getGameCamera().getxOffset() / Tile.TILEWIDTH -> will convert offset in pixel to offset in tiles
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        // Check if width is greater or less than offset in tiles in x - direction.
        // (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1 -> will convert offset in pixel to offset in tiles
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);

        for (int y = 0; y < height; y++)
        {
            for (int x = xStart; x < xEnd; x++)
            {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (y * Tile.TILEHEIGHT));
            }
        }
    }

    public Tile getTile(int x, int y)
    {
        Tile t = Tile.tiles[tiles[x][y]];
        // return a default tile.
        if (t == null)
        {
            return Tile.groundTile;
        }

        return t;
    }

    // set values for the tiles array
    private void loadWorld(String path)
    {
        String file = Utils.loadFileAssString(path);
        String[] tokens = file.split("\\s+");

        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnx = Utils.parseInt(tokens[2]);
        spawny = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                // (x + y * width) will convert x & y in loop to one dimensional array.
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
