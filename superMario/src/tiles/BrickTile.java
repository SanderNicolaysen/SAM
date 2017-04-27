package tiles;

import graphics.Assets;

public class BrickTile extends Tile
{
    public BrickTile(int id)
    {
        super(Assets.levelPlatform2, id);
    }

    public boolean isSolid()
    {
        return true;
    }

}
