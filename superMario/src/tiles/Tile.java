package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile
{

    // STATIC

    public static Tile[] tiles = new Tile[256];
    public static Tile groundTile = new GroundTile(0);

    // CLASS
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;

    // id of our tile (every tile will have it's own id)
    protected final int id;

    /**
     * Method that will set different indexes of tiles array to different tile classes.
     * @param texture the bufferedImage we want to set
     * @param id the id of our tile
     */
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;

        // Equal to the current tile that called the constructor.
        tiles[id] = this;
    }

    public void tick()
    {

    }

    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    /**
     * Collision detection with tile:
     * If true: the tile is a solid block, and you will not be able to walk through it.
     * If false: the tile is not a solid block, so you can walk through it.
     * @return if you can walk through tile or not.
     */
    public boolean isSolid()
    {
        return false;
    }

    public int getId()
    {
        return id;
    }
}
