package tiles;

import java.awt.image.BufferedImage;

public class MushroomTile extends Tile
{
    public MushroomTile(BufferedImage texture, int id)
    {
        super(texture, id);
    }

    public boolean isSolid()
    {
        return true;
    }
}
