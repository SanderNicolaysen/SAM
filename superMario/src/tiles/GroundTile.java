package tiles;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class GroundTile extends Tile
{

    /**
     *
     * @param id the id of our tile
     */
    public GroundTile(BufferedImage textures, int id)
    {
        super(textures, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }
}
