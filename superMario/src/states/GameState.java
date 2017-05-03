package states;

import entities.creatures.Mario;
import game.Handler;
import graphics.Assets;
import input.KeyManager;
import sounds.Sound;
import utils.Utils;
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


        if (handler.getKeyManager().pauseSound)
        {
            handler.getSound().playSound(Sound.pauseSound);
            State.setState(handler.getGame().menuState);
        }


        // Score
        if (handler.getKeyManager().pause)
        {
            handler.getGame().highScore = Utils.loadFileAssString("res/worlds/savefile.txt");
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
