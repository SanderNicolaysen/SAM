package states;

import entities.creatures.Mario;
import entities.creatures.SuperMario;
import game.Handler;
import graphics.Assets;
import worlds.World;

import java.awt.*;

/**
 * The class for our GameState
 */
public class GameState extends State {

    private SuperMario supermario;
    private Mario mario;
    private World world;

    // Constructor
    public GameState(Handler handler)
    {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
        // (x, y): start position of SuperMario
        mario = new Mario(handler, 150, 1080 - 64 * 3);
        supermario = new SuperMario(handler, 150, 1080 - 64 * 3);

    }

    @Override
    public void tick()
    {
        world.tick();
        supermario.tick();
        mario.tick();
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.bg,0, 0, 1920, 1080, null);
        world.render(g);
        supermario.render(g);
        mario.render(g);
    }
}
