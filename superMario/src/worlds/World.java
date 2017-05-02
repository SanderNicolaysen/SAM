package worlds;

import entities.EntityManager;
import entities.creatures.*;
import entities.items.Coin;
import entities.staticEntities.Tube;
import game.Handler;
import sounds.Sound;
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

    public void initEntities()
    {
        // player
        entityManager = new EntityManager(handler, new Mario(handler, 150, 895,1));

        // Enemies
        //entityManager.addEntity(new GreenKoopaTroopa(handler, 120 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 2, 1));
        //entityManager.addEntity(new RedKoopaTroopa(handler, 100 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 2, 1));
        //entityManager.addEntity(new FlyingGreenKoopaTroopa(handler, 45 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 3, 1));
        //entityManager.addEntity(new FlyingRedKoopaTroopa(handler, 50 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 2, 1));
        //entityManager.addEntity(new Lakitu(handler, 70 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 4, 1));
        //entityManager.addEntity(new Bowser(handler, 140 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 2, 1));
        //entityManager.addEntity(new PiranhaPlant(handler,22 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 2, 1));
        //entityManager.addEntity(new Beetle(handler, 90 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_16x16_HEIGHT * 2, 1));
        entityManager.addEntity(new HammerBrother(handler, 22 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 2, 1));
        //entityManager.addEntity(new Goomba(handler, 53 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_16x16_HEIGHT * 10, 1));
        //entityManager.addEntity(new BulletBill(handler, 78 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_16x16_HEIGHT * 8, 1));
        //entityManager.addEntity(new Coin(handler, 22 * Tile.TILEWIDTH, handler.getHeight() - Creature.DEFAULT_32x32_HEIGHT * 4, 1));

        entityManager.getMario().setX(spawnx);
        entityManager.getMario().setY(spawny);
    }

    // Load world from a file.
    public World(Handler handler, String path)
    {
        this.handler = handler;
        loadWorld(path);
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
            //State.setState(handler.getGame().gameOver);

            //handler.getWorld().getEntityManager().getMario().setHealth(0);
            return Tile.background;
        }


        Tile t = Tile.tiles[tiles[x][y]];
        // return a default tile.
        if (t == null)
        {
            return Tile.background;
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
