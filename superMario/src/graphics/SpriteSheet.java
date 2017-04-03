package graphics;

import java.awt.image.BufferedImage;

/**
 * Class that can crop out an image from a sprite sheet.
 */
public class SpriteSheet
{
    private BufferedImage sheet;

    /**
     * Constructor for a bufferedImage.
     * @param sheet A BufferedImage
     */
    public SpriteSheet(BufferedImage sheet)
    {
        this.sheet = sheet;
    }

    /**
     * This method will return a new BufferedImage of the area of the sprite sheet we specifie.
     * @param x the x coordinate of the upper-left corner
     * @param y the y coordinate of the upper-left corner
     * @param width the width of our image
     * @param height the height of our image
     * @return
     */
    public BufferedImage crop(int x, int y, int width, int height)
    {
        return sheet.getSubimage(x, y, width, height);
    }
}
