package states;

import entities.creatures.Mario;
import entities.creatures.SuperMario;
import game.Handler;
import graphics.Assets;
import input.KeyManager;
import worlds.World;

import java.awt.*;

/**
 * The class for our GameState
 */
public class GameState extends State {

    private World world;

    // Constructor
    public GameState(Handler handler)
    {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick()
    {
        world.tick();
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.bg,0, 0, 1920, 1080, null);
        world.render(g);
    }
}
