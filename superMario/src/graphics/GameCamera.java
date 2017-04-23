package graphics;

import entities.Entity;
import game.Handler;
import tiles.Tile;

public class GameCamera
{
    private Handler handler;
    // Position/offset from original position.
    private float xOffset;

    public GameCamera(Handler handler, float xOffset)
    {
        this.handler = handler;
        this.xOffset = xOffset;
    }

    public void checkBlankSpace()
    {
        // Blank space at begging of map
        if (xOffset < 0)
        {
            xOffset = 0;
        }
        // Blank space at end of map
        else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth())
        {
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }
    }

    // Center camera on specific entity
    public void centerOnEntity(Entity e)
    {
        // x position of entity - width of screen / 2 + entity's width / 2.
        // x position of entity - middle of screen in x direction = distance between entity and middle.
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        checkBlankSpace();
    }

    public void move(float xAmount, float yAmount)
    {
        xOffset += xAmount;
        checkBlankSpace();
    }

    public float getxOffset()
    {
        return xOffset;
    }

    public void setxOffset(float xOffset)
    {
        this.xOffset = xOffset;
    }
}
