package states;

import graphics.Assets;

import java.awt.*;

/**
 * The class for our GameState
 */
public class GameState extends State
{
    // Constructor
    public GameState()
    {

    }
    int x = 0;
    @Override
    public void tick()
    {
        x += 2;
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.CYAN.darker());
        g.fillRect(0, 0, 900, 700);

        g.setColor(Color.GREEN.darker());
        g.fillRect(0, 600, 900, 100);

        g.setColor(Color.RED.darker());
        g.fillRect(x, 580, 20, 20);

        g.drawImage(Assets.ground, 0, 0, null);
    }
}
