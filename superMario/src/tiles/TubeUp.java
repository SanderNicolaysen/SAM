package tiles;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class TubeUp extends Tile
{
    public TubeUp(BufferedImage textures, int id)
    {
        super(textures, id);
    }

    public boolean isSolid()
    {
        return true;
    }
}
