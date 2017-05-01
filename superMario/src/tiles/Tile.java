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

    // Backgrounds
    public static Tile groundTile = new GroundTile(Assets.ground, 0);
    //public static Tile skyBackground = new Background(Assets.skyBackground,1);
    public static Tile background = new Background(Assets.bg, 1);
    public static Tile lavaBackground = new Background(Assets.lavaBackground, 2);
    public static Tile waterBackground = new Background(Assets.waterBackground, 3);
    public static Tile Blackbackground = new Background(Assets.blackBackground, 4);

    // Bricks
    public static Tile brickTile = new BrickTile(Assets.levelPlatform4, 5);
    public static Tile levelPlatform6 = new BrickTile(Assets.levelPlatform6, 6);

    // Single Clouds
    public static Tile singleCloudTile1 = new CloudTile(Assets.singleCloud1,7);
    public static Tile singleCloudTile2 = new CloudTile(Assets.singleCloud2,8);
    public static Tile singleCloudTile3 = new CloudTile(Assets.singleCloud3,9);
    public static Tile singleCloudTile4 = new CloudTile(Assets.singleCloud4,10);

    // Double clouds
    public static Tile doubleCloudTile1 = new CloudTile(Assets.doubleCloud1, 11);
    public static Tile doubleCloudTile2 = new CloudTile(Assets.doubleCloud2, 12);
    public static Tile doubleCloudTile3 = new CloudTile(Assets.doubleCloud3, 13);
    public static Tile doubleCloudTile4 = new CloudTile(Assets.doubleCloud4, 14);
    public static Tile doubleCloudTile5 = new CloudTile(Assets.doubleCloud5, 15);
    public static Tile doubleCloudTile6 = new CloudTile(Assets.doubleCloud6, 16);

    // Triple Clouds
    public static Tile tripleCloudTile1 = new CloudTile(Assets.tripleCloud1, 17);
    public static Tile tripleCloudTile2 = new CloudTile(Assets.tripleCloud2, 18);
    public static Tile tripleCloudTile3 = new CloudTile(Assets.tripleCloud3, 19);
    public static Tile tripleCloudTile4 = new CloudTile(Assets.tripleCloud4, 20);
    public static Tile tripleCloudTile5 = new CloudTile(Assets.tripleCloud5, 21);
    public static Tile tripleCloudTile6 = new CloudTile(Assets.tripleCloud6, 22);
    public static Tile tripleCloudTile7 = new CloudTile(Assets.tripleCloud7, 23);
    public static Tile tripleCloudTile8 = new CloudTile(Assets.tripleCloud8, 24);

    // Tube
    public static Tile tubeUp1 = new Tube(Assets.tubeUp1,25);
    public static Tile tubeUp2 = new Tube(Assets.tubeUp2,26);
    public static Tile tubeUp3 = new Tube(Assets.tubeUp3,27);
    public static Tile tubeUp4 = new Tube(Assets.tubeUp4,28);
    public static Tile tubeMiddle1 = new Tube(Assets.tubeMiddle1, 29);
    public static Tile tubeMiddle2 = new Tube(Assets.tubeMiddle2, 30);
    public static Tile tubeMiddle3 = new Tube(Assets.tubeMiddle3, 31);
    public static Tile tubeMiddle4 = new Tube(Assets.tubeMiddle4, 32);

    // HillTile
    public static Tile smallHillTile1 = new HillTile(Assets.smallHill1, 33);
    public static Tile smallHillTile2 = new HillTile(Assets.smallHill2, 34);
    public static Tile smallHillTile3 = new HillTile(Assets.smallHill3, 35);
    public static Tile smallHillTile4 = new HillTile(Assets.smallHill4, 36);
    public static Tile smallHillTile5 = new HillTile(Assets.smallHill5, 37);
    public static Tile smallHillTile6 = new HillTile(Assets.smallHill6, 38);

    // Big trees
    public static Tile bigTree1 = new TreeTile(Assets.bigThree1, 39);
    public static Tile bigTree2 = new TreeTile(Assets.bigThree2, 40);
    public static Tile bigTree3 = new TreeTile(Assets.bigThree3, 41);

    // Small trees
    public static Tile smallTree1 = new TreeTile(Assets.smallThree1, 42);
    public static Tile smallTree2 = new TreeTile(Assets.smallThree2, 43);

    // tree platform
    public static Tile treeTopLeft = new TreePlatformTile(Assets.threeTopLeft, 44);
    public static Tile treeTopMiddle = new TreePlatformTile(Assets.threeTopMiddle, 45);
    public static Tile treeTopRight = new TreePlatformTile(Assets.threeTopRight, 46);
    public static Tile treeWood = new TreePlatformTile(Assets.threeWood, 47);

    // grid
    public static Tile grid = new TreeTile(Assets.grid, 48);

    // Mushroom platform
    public static Tile mushRoomTopLeft = new MushroomTile(Assets.mushroomTopLeft, 49);
    public static Tile mushRoomTopMiddle = new MushroomTile(Assets.mushroomTopLeft, 50);
    public static Tile mushRoomTopRight = new MushroomTile(Assets.mushroomTopLeft, 51);
    public static Tile mushRoomstemTop = new MushroomTile(Assets.mushroomStemTop, 52);
    public static Tile mushRoomstemelse = new MushroomTile(Assets.mushroomStemElse, 53);

    // BigHill Tile
    public static Tile BigHillTile1 = new HillTile(Assets.bigHill1, 54);
    public static Tile BigHillTile2 = new HillTile(Assets.bigHill2, 55);
    public static Tile BigHillTile3 = new HillTile(Assets.bigHill3, 56);
    public static Tile BigHillTile4 = new HillTile(Assets.bigHill4, 57);
    public static Tile BigHillTile5 = new HillTile(Assets.bigHill5, 58);
    public static Tile BigHillTile6 = new HillTile(Assets.bigHill6, 59);
    public static Tile BigHillTile7 = new HillTile(Assets.bigHill7, 60);
    public static Tile BigHillTile8 = new HillTile(Assets.bigHill8, 61);
    public static Tile BigHillTile9 = new HillTile(Assets.bigHill9, 62);
    public static Tile BigHillTile10 = new HillTile(Assets.bigHill10, 63);
    public static Tile BigHillTile11 = new HillTile(Assets.bigHill11, 64);
    public static Tile BigHillTile12 = new HillTile(Assets.bigHill12, 65);
    public static Tile BigHillTile13 = new HillTile(Assets.bigHill13, 66);
    public static Tile BigHillTile14 = new HillTile(Assets.bigHill14, 67);
    public static Tile BigHillTile15 = new HillTile(Assets.bigHill15, 68);

    // Castle tile
    public static Tile castle1 = new CastleTile(Assets.smallCastle1, 69);
    public static Tile castle2 = new CastleTile(Assets.smallCastle2, 70);
    public static Tile castle3 = new CastleTile(Assets.smallCastle3, 71);
    public static Tile castle4 = new CastleTile(Assets.smallCastle4, 72);
    public static Tile castle5 = new CastleTile(Assets.smallCastle5, 73);
    public static Tile castle6 = new CastleTile(Assets.smallCastle6, 74);
    public static Tile castle7 = new CastleTile(Assets.smallCastle7, 75);
    public static Tile castle8 = new CastleTile(Assets.smallCastle8, 76);
    public static Tile castle9 = new CastleTile(Assets.smallCastle9, 77);
    public static Tile castle10 = new CastleTile(Assets.smallCastle10, 78);
    public static Tile castle11 = new CastleTile(Assets.smallCastle11, 79);
    public static Tile castle12 = new CastleTile(Assets.smallCastle12, 80);
    public static Tile castle13 = new CastleTile(Assets.smallCastle13, 81);
    public static Tile castle14 = new CastleTile(Assets.smallCastle14, 82);
    public static Tile castle15 = new CastleTile(Assets.smallCastle15, 83);
    public static Tile castle16 = new CastleTile(Assets.smallCastle16, 84);
    public static Tile castle17 = new CastleTile(Assets.smallCastle17, 85);
    public static Tile castle18 = new CastleTile(Assets.smallCastle18, 86);
    public static Tile castle19 = new CastleTile(Assets.smallCastle19, 87);
    public static Tile castle20 = new CastleTile(Assets.smallCastle20, 88);
    public static Tile castle21 = new CastleTile(Assets.smallCastle21, 89);
    public static Tile castle22 = new CastleTile(Assets.smallCastle22, 90);
    public static Tile castle23 = new CastleTile(Assets.smallCastle23, 91);
    public static Tile castle24 = new CastleTile(Assets.smallCastle24, 92);
    public static Tile castle25 = new CastleTile(Assets.smallCastle25, 93);

    // Lava
    public static Tile lava = new Background(Assets.lava, 94);
    // Water
    public static Tile water = new Background(Assets.water, 95);

    public static Tile levelPlatform1 = new BrickTile(Assets.levelPlatform1, 96);

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
