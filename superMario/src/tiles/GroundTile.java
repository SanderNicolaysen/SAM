package tiles;

import graphics.Assets;

public class GroundTile extends Tile
{

    /**
     *
     * @param id the id of our tile
     */
    public GroundTile(int id)
    {
        super(Assets.ground, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }
}
