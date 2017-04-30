package tiles;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class Tube extends Tile
{
    public Tube(BufferedImage textures, int id)
    {
        super(textures, id);
    }

    public boolean isSolid()
    {
        return true;
    }
}
