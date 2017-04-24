package graphics;

import java.awt.image.BufferedImage;

/**
 *
 * This class will load inn all of our assets (Textures, images, sounds etc).
 */
public class Assets
{
    private static final int width = 32, height = 32;

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
        SpriteSheet superMarioSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/mariosprite1.png"));
        SpriteSheet worldSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/smb1_misc_sprites.gif"));

        ground = worldSheet.crop(373, 124, 16, 16);
        bg = worldSheet.crop(274, 341, 306 - 274, 360 - 341);

        //Mario's right movements
        marioRightNormal = superMarioSheet.crop((width * 4), height, width-16, height-15);
        marioRightJump = superMarioSheet.crop(0, height, width-15, height-16);
        marioRightMove = new BufferedImage[3];
        marioRightMove[2] = superMarioSheet.crop(width, height, width-15, height-15);
        marioRightMove[1] = superMarioSheet.crop((width*2), height, width-16, height-15);
        marioRightMove[0] = superMarioSheet.crop((width*3), height, width-15, height-15);

        //Mario's left movements
        marioLeftNormal = superMarioSheet.crop((width * 4), 0, width-17, height-15);
        marioLeftJump = superMarioSheet.crop(0, 0, width-15, height-16);
        marioLeftMove = new BufferedImage[3];
        marioLeftMove[2] = superMarioSheet.crop(width, 0, width-15, height-15);
        marioLeftMove[1] = superMarioSheet.crop((width * 2), 0, width-18, height-15);
        marioLeftMove[0] = superMarioSheet.crop((width * 3), 0, width-17, height-15);

        //Mario's death movement
        marioDeath = superMarioSheet.crop((width * 5), 0, width-16, height-15);

        //Super Mario's right movements
        superMarioRightNormal = superMarioSheet.crop(0, 0, width, height);
        superMarioRightJump = superMarioSheet.crop(0, 0, width, height);
        superMarioRightCrouch = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove = new BufferedImage[3];
        superMarioRightMove[0] = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove[1] = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove[2] = superMarioSheet.crop(0, 0, width, height);

        //Super Mario's left movements
        superMarioLeftNormal = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftJump = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftCrouch = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove = new BufferedImage[3];
        superMarioLeftMove[0] = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove[1] = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove[2] = superMarioSheet.crop(0, 0, width, height);
    }
}
