package game;

import graphics.GameCamera;
import input.KeyManager;
import input.MouseManager;
import sounds.Sound;
import worlds.World;

//This class will make it easier to pass along objects.
public class Handler
{
    private Game game;
    private World world;

    public Handler(Game game)
    {
        this.game = game;
    }

    public GameCamera getGameCamera()
    {
        return game.getGameCamera();
    }

    public int getWidth()
    {
        return game.getWidth();
    }

    public int getHeight()
    {
        return game.getHeight();
    }

    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    public World getWorld()
    {
        return world;
    }

    public void setWorld(World world)
    {
        this.world = world;
    }

    public Sound getSound()
    {
        return game.getSound();
    }
}
