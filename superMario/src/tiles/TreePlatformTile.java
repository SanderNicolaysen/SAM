package tiles;


import java.awt.image.BufferedImage;

public class TreePlatformTile extends Tile
{
    public TreePlatformTile(BufferedImage texture, int id)
    {
        super(texture, id);
    }

    public boolean isSolid()
    {
        return true;
    }
}
