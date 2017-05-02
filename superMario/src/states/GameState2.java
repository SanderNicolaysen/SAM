package states;

import game.Handler;
import worlds.World;

import java.awt.*;

public class GameState2 extends State
{
    private World world2;

    public GameState2(Handler handler)
    {
        super(handler);
        world2 = new World(handler, "res/worlds/world2.txt");
        handler.setWorld(world2);
    }

    @Override
    public void tick()
    {
        world2.tick();


        if (handler.getKeyManager().pause)
        {
            State.setState(handler.getGame().menuState);
        }
    }

    @Override
    public void render(Graphics g)
    {
        world2.render(g);

        // Score
        g.setColor(Color.BLACK);
        g.setFont(new Font("score", Font.BOLD, 60));
        g.drawString("Score: " + handler.getWorld().getEntityManager().getMario().getScore(), 100, 100);
    }
}
