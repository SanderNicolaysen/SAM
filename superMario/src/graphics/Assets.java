package graphics;

import java.awt.image.BufferedImage;

/**'
 *
 * This class will load inn all of our assets (Textures, images, sounds etc).
 */
public class Assets
{
    private static final int width = 32, height = 32;

    // Different tiles/images that will be equal to cropped out pictures of our sprite sheet.
    public static BufferedImage player, ground;

    /**
     * This method will load in all the assets we need in our game.
     * It will only run once, so we don't have to crop out images several times.
     */
    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/smb1_misc_sprites.gif"));

        player = sheet.crop(0, 0, width, height);
        ground = sheet.crop(0, 0, 200, 200);


    }
}
