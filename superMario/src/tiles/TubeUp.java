package tiles;

import graphics.Assets;

public class TubeUp extends Tile
{
    public TubeUp(int id)
    {
        super(Assets.tubeUp, id);
    }

    public boolean isSolid()
    {
        return true;
    }
}
