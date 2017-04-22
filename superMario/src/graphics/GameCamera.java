package graphics;

import entities.Entity;
import handler.Game;

public class GameCamera
{
    private Game game;
    // Position/offset from original position.
    private float xOffset, yOffset;

    public GameCamera(Game game, float xOffset, float yOffset)
    {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    // Center camera on specific entity
    public void centerOnEntity(Entity e)
    {
        // x position of entity - width of screen / 2 + entity's width / 2.
        xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
        // y position of entity - height of screen / 2 + entity's height / 2.
        yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
    }

    public void move(float xAmount, float yAmount)
    {
        xOffset += xAmount;
        yOffset += yAmount;
    }

    public float getxOffset()
    {
        return xOffset;
    }

    public void setxOffset(float xOffset)
    {
        this.xOffset = xOffset;
    }

    public float getyOffset()
    {
        return yOffset;
    }

    public void setyOffset(float yOffset)
    {
        this.yOffset = yOffset;
    }
}
