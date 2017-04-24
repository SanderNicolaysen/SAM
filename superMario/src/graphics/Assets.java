package graphics;

import java.awt.image.BufferedImage;

/**
 *
 * This class will load inn all of our assets (Textures, images, sounds etc).
 */
public class Assets
{
    private static final int width = 16, height = 16;

    // Different tiles/images that will be equal to cropped out pictures of our sprite sheet.

    public static BufferedImage marioRightNormal, marioRightJump, marioLeftNormal, marioLeftJump, marioDeath,
            superMarioRightNormal, superMarioRightCrouch, superMarioRightJump, superMarioLeftNormal, superMarioLeftCrouch, superMarioLeftJump,
            ground, bg;

    public static BufferedImage[] marioRightMove;
    public static BufferedImage[] marioLeftMove;
    public static BufferedImage[] superMarioRightMove;
    public static BufferedImage[] superMarioLeftMove;


    /**
     * This method will load in all the assets we need in our game.
     * It will only run once, so we don't have to crop out images several times.
     */
    public static void init()
    {
        SpriteSheet superMarioSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/mario.png"));
        SpriteSheet worldSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/smb1_misc_sprites.gif"));

        ground = worldSheet.crop(373, 124, 16, 16);
        bg = worldSheet.crop(274, 341, 306 - 274, 360 - 341);

        //Mario's right movements
        marioRightNormal = superMarioSheet.crop((width * 14) - 1, 0, width, height);

        // Right movement
        marioRightJump = superMarioSheet.crop(0, 0, width, height);
        marioRightMove = new BufferedImage[2];
        marioRightMove[0] = superMarioSheet.crop(0, 0, width, height);
        marioRightMove[1] = superMarioSheet.crop(0, 0, width, height);
        marioRightMove[2] = superMarioSheet.crop(0, 0, width, height);

        //Mario's left movements
        marioLeftNormal = superMarioSheet.crop(0, 0, width, height);

        // Left movement
        marioLeftJump = superMarioSheet.crop(0, 0, width, height);
        marioLeftMove = new BufferedImage[2];
        marioLeftMove[0] = superMarioSheet.crop(0, 0, width, height);
        marioLeftMove[1] = superMarioSheet.crop(0, 0, width, height);
        marioLeftMove[2] = superMarioSheet.crop(0, 0, width, height);

        //Mario's death movement
        marioDeath = superMarioSheet.crop(0, 0, width, height);

        //Super Mario's right movements
        superMarioRightNormal = superMarioSheet.crop(0, 0, width, height);
        superMarioRightJump = superMarioSheet.crop(0, 0, width, height);
        superMarioRightCrouch = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove = new BufferedImage[2];
        superMarioRightMove[0] = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove[1] = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove[2] = superMarioSheet.crop(0, 0, width, height);

        //Super Mario's left movements
        superMarioLeftNormal = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftJump = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftCrouch = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove = new BufferedImage[2];
        superMarioLeftMove[0] = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove[1] = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove[2] = superMarioSheet.crop(0, 0, width, height);
    }
}
