package states;

import entities.creatures.SuperMario;
import handler.Handler;
import worlds.World;

import java.awt.*;

/**
 * The class for our GameState
 */
public class GameState extends State {

    private SuperMario supermario;
    private World world;

    // Constructor
    public GameState(Handler handler)
    {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
        // (x, y): start position of SuperMario
        supermario = new SuperMario(handler, 100, 100);
    }

    @Override
    public void tick()
    {
        world.tick();
        supermario.tick();
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
        supermario.render(g);
    }
}
