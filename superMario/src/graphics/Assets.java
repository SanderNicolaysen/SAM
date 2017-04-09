package graphics;

import java.awt.image.BufferedImage;

/**'
 *
 * This class will load inn all of our assets (Textures, images, sounds etc).
 */
public class Assets
{
    private static final int width = 32, height = 16;

    // Different tiles/images that will be equal to cropped out pictures of our sprite sheet.

    public static BufferedImage marioRightNormal, marioRightMove1, marioRightMove2, marioRightMove3, marioRightJump,
            marioLeftNormal, marioLeftMove1, marioLeftMove2, marioLeftMove3, marioLeftJump, marioDeath,
            superMarioRightNormal, superMarioRightMove1, superMarioRightMove2, superMarioRightMove3, superMarioRightJump, superMarioRightCrouch,
            superMarioLeftNormal, superMarioLeftMove1, superMarioLeftMove2, superMarioLeftMove3, superMarioLeftJump, superMarioLeftCrouch;

    /**
     * This method will load in all the assets we need in our game.
     * It will only run once, so we don't have to crop out images several times.
     */
    public static void init()
    {
        SpriteSheet superMarioSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/Mario.png"));

        //Mario's right movements
        marioRightNormal = superMarioSheet.crop(0, 0, width, height);
        marioRightMove1 = superMarioSheet.crop(0, 0, width, height);
        marioRightMove2 = superMarioSheet.crop(0, 0, width, height);
        marioRightMove3 = superMarioSheet.crop(0, 0, width, height);
        marioRightJump = superMarioSheet.crop(0, 0, width, height);
        //Mario's left movements
        marioLeftNormal = superMarioSheet.crop(0, 0, width, height);
        marioLeftMove1 = superMarioSheet.crop(0, 0, width, height);
        marioLeftMove2 = superMarioSheet.crop(0, 0, width, height);
        marioLeftMove3 = superMarioSheet.crop(0, 0, width, height);
        marioLeftJump = superMarioSheet.crop(0, 0, width, height);
        //Mario's death movement
        marioDeath = superMarioSheet.crop(0, 0, width, height);
        //Super Mario's right movements
        superMarioRightNormal = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove1 = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove2 = superMarioSheet.crop(0, 0, width, height);
        superMarioRightMove3 = superMarioSheet.crop(0, 0, width, height);
        superMarioRightJump = superMarioSheet.crop(0, 0, width, height);
        superMarioRightCrouch = superMarioSheet.crop(0, 0, width, height);
        //Super Mario's left movements
        superMarioLeftNormal = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove1 = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove2 = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftMove3 = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftJump = superMarioSheet.crop(0, 0, width, height);
        superMarioLeftCrouch = superMarioSheet.crop(0, 0, width, height);
    }
}
