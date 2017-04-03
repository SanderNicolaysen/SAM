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
    int y = 0;
    @Override
    public void tick()
    {
        x++;
        y += 2;
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.ground, 0, 0, null);
        g.setColor(Color.RED);
        g.fillRect(x, 400, x, 50);
    }
}
