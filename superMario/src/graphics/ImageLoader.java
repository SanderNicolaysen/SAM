package graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class will load images for us.
 */

public class ImageLoader
{
    public static Image imageLoader(String path)
    {
        try
        {
            FileInputStream f = new FileInputStream(path);
            BufferedInputStream bf = new BufferedInputStream(f);
            Image img = ImageIO.read(bf);

            return img;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    // Funket ikke med g.drawImage()
    /* public static BufferedImage loadImage(String path)
    {
        try
        {
            return ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    */
}
