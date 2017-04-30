package states;

import game.Handler;

import java.awt.*;

/**
 * State for our settings
 */
public class SettingsState extends State
{

    // Constructor
    public SettingsState(Handler handler)
    {
        super(handler);
    }

    @Override
    public void tick()
    {
        System.out.println("hei");
    }

    @Override
    public void render(Graphics g)
    {

    }
}
