package tiles;

import graphics.Assets;

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
    public static Tile brickTile = new BrickTile(2);
    public static Tile singleCloudTile = new CloudTile(Assets.singleCloud,3);
    public static Tile doubleCloudTile = new CloudTile(Assets.doubleCloud, 4);
    public static Tile tripleCloudTile = new CloudTile(Assets.trippleCloud, 5);

    // TubeUp
    public static Tile tubeUpLeftTile = new TubeUp(Assets.tubeUpLeft,6);
    public static Tile tubeUpLeftDownTile = new TubeUp(Assets.tubeUpLeftDown,7);
    public static Tile tubeUpRightTile = new TubeUp(Assets.tubeUpRight,8);
    public static Tile tubeUpRightDownTile = new TubeUp(Assets.tubeUpRightDown,9);

    public static Tile grassTile1 = new GrassTile(Assets.smallHill1, 10);
    public static Tile grassTile2 = new GrassTile(Assets.smallHill2, 11);


    public static final int TILEWIDTH = 64 , TILEHEIGHT = 64;

    // CLASS

    // Every tile will have it's own id and texture.
    protected BufferedImage texture, texture32x32, texture48x48, texture64x64, texture80x80, texture176x176;
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
