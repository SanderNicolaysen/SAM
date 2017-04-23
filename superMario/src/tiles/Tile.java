package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class will hold what every tile needs.
 */
public class Tile
{
    public static Tile[] tiles = new Tile[256];
    public static Tile groundTile = new GroundTile(0);
    public static Tile Background = new Background(1);

    public static final int TILEWIDTH = 64 , TILEHEIGHT = 64;

    // CLASS

    // Every tile will have it's own id and texture.
    protected BufferedImage texture;
    protected final int id;

    /**
     * Constructor that will set id, texture and index of tiles array
     * for the object that got initialized.
     * @param texture the texture of our tile
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

    // Render a tile to the screen.
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    /**
     * If true: collision detection with tile
     * If false: no collision detection
     * @return false (you can walk on tile)
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
