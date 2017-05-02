package states;

import entities.creatures.Mario;
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


        if (handler.getKeyManager().pause)
        {
            State.setState(handler.getGame().menuState);
        }

    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.bg,0, 0, handler.getWidth(), handler.getHeight(), null);
        world.render(g);

        // Score
        g.setColor(Color.BLACK);
        g.setFont(new Font("score", Font.BOLD, 60));
        g.drawString("Score: " + handler.getWorld().getEntityManager().getMario().getScore(), 100, 100);
    }
}
