package worlds;

import game.Game;
import tiles.Tile;
import utils.Utils;

import java.awt.*;

public class World
{
    private Game game;
    private int width, height;
    private int spawnx, spawny;

    // Holds id's saying which tile should be rendered in which position.
    private int[][] tiles;

    // Load world from a file.
    public World(Game game, String path)
    {
        this.game = game;
        loadWorld(path);
    }

    public void tick()
    {

    }

    // Render every tile to the screen.
    public void render(Graphics g)
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
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
}
