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
    /**
     * Method that will load an image.
     * @param path the path the image is located
     * @return A BufferedImage
     */
    public static BufferedImage loadeImage(String path)
    {
        try
        {
            FileInputStream f = new FileInputStream(path);
            BufferedInputStream bf = new BufferedInputStream(f);
            BufferedImage bimg = ImageIO.read(bf);

            return bimg;
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
}
