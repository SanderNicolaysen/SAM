package states;

import game.Handler;

import java.awt.*;

public class GameOver extends State
{

    public GameOver(Handler handler)
    {
        super(handler);
    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        g.setFont(new Font("marioFont", Font.BOLD, 60));
        g.setColor(Color.RED);
        g.drawString("GAME OVER BITCH!", handler.getWidth() / 2 - 300, handler.getHeight() / 2);
    }
}
