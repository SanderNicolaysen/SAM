package worlds;

import entities.EntityManager;
import entities.creatures.Creature;
import entities.creatures.GreenKoopaTroopa;
import entities.creatures.Mario;
import entities.creatures.SuperMario;
import entities.staticEntities.Tube;
import game.Handler;
import states.State;
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

    //Entities
    private EntityManager entityManager;

    // Load world from a file.
    public World(Handler handler, String path)
    {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Mario(handler, 150, handler.getHeight() - Tile.TILEHEIGHT * 3));
        //entityManager.addEntity(new Tube(handler, 100, 100));
        //entityManager.addEntity(new SuperMario(handler, 300, 300));
        entityManager.addEntity(new GreenKoopaTroopa(handler, 31 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_SUPERMARIO_HEIGHT * 2));

        loadWorld(path);

        entityManager.getMario().setX(spawnx);
        entityManager.getMario().setY(spawny);
    }

    public void tick()
    {
        entityManager.tick();
    }

    // Render every tile to the screen.
    public void render(Graphics g)
    {
        // Render efficiency

        // check if 0 is greater or less than offset in tiles in x - direction.
        // game.getGameCamera().getxOffset() / Tile.TILEWIDTH -> will convert offset in pixel to offset in tiles
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        // Check if width is greater or less than offset in tiles in x - direction.
        // (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILEWIDTH + 1 -> will convert offset in pixel to offset in tiles
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);

        for (int y = 0; y < height; y++)
        {
            for (int x = xStart; x < xEnd; x++)
            {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //Entities
        entityManager.render(g);
    }

    public Tile getTile(int x, int y)
    {
        // If player is outside of map return a tile so the game won't crash
        if (x < 0 || y < 0 || x >= width || y >= height)
        {
            //State.setState(handler.getGame().menuState);
            //handler.getKeyManager().enter = false;

            //entityManager.getMario().setX(150);
            //entityManager.getMario().setY(888);
            return Tile.Background;
        }


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

    public EntityManager getEntityManager() {
        return entityManager;
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
