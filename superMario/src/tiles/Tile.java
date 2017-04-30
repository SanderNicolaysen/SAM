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

    // Clouds
    public static Tile singleCloudTile1 = new CloudTile(Assets.singleCloud1,3);
    public static Tile singleCloudTile2 = new CloudTile(Assets.singleCloud2,4);
    public static Tile singleCloudTile3 = new CloudTile(Assets.singleCloud3,5);
    public static Tile singleCloudTile4 = new CloudTile(Assets.singleCloud4,6);

    public static Tile doubleCloudTile1 = new CloudTile(Assets.doubleCloud1, 7);
    public static Tile doubleCloudTile2 = new CloudTile(Assets.doubleCloud1, 8);
    public static Tile doubleCloudTile3 = new CloudTile(Assets.doubleCloud1, 9);
    public static Tile doubleCloudTile4 = new CloudTile(Assets.doubleCloud1, 10);
    public static Tile doubleCloudTile5 = new CloudTile(Assets.doubleCloud1, 11);
    public static Tile doubleCloudTile6 = new CloudTile(Assets.doubleCloud1, 12);

    public static Tile tripleCloudTile = new CloudTile(Assets.tripleCloud1, 8);

    // TubeUp
    public static Tile tubeUpLeftTile = new TubeUp(Assets.tubeUp1,9);
    public static Tile tubeUpLeftDownTile = new TubeUp(Assets.tubeUp3,10);
    public static Tile tubeUpRightTile = new TubeUp(Assets.tubeUp2,11);
    public static Tile tubeUpRightDownTile = new TubeUp(Assets.tubeUp4,12);

    public static Tile grassTile1 = new GrassTile(Assets.smallHill1, 13);
    public static Tile grassTile2 = new GrassTile(Assets.smallHill2, 14);


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

    public void tick() {}

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
