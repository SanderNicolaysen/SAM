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
    public static BufferedImage marioRightNormal, marioRightMove1, marioRightMove2, marioRightMove3,
            marioRightJump, marioDeath, marioLeftNormal, marioLeftMove1, marioLeftMove2, marioLeftMove3,
            marioLeftJump, ground;

    /**
     * This method will load in all the assets we need in our game.
     * It will only run once, so we don't have to crop out images several times.
     */
    public static void init()
    {

        SpriteSheet mariosheet = new SpriteSheet(ImageLoader.loadImage("res/textures/mario.png"));

        marioRightNormal = mariosheet.crop(211, 0, width, 16);
        marioRightMove1 = mariosheet.crop(0, 0, width, height);
        marioRightMove2 = mariosheet.crop(0, 0, width, height);
        marioRightMove3 = mariosheet.crop(0, 0, width, height);
        marioRightJump = mariosheet.crop(0, 0, width, height);

        marioLeftNormal = mariosheet.crop(0, 0, width, height);
        marioLeftMove1 = mariosheet.crop(0, 0, width, height);
        marioLeftMove2 = mariosheet.crop(0, 0, width, height);
        marioLeftMove3 = mariosheet.crop(0, 0, width, height);
        marioLeftJump = mariosheet.crop(0, 0, width, height);

        marioDeath = mariosheet.crop(0, 0, width, height);

        ground = mariosheet.crop(0, 0, width * 2, height * 2);

    }
}
