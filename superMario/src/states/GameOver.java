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
        g.fillRect(0, 0, 1920, 1080);
        g.setFont(new Font("marioFont", Font.BOLD, 60));
        g.setColor(Color.WHITE);
        g.drawString("GAME OVER", handler.getWidth() / 2 - 300, handler.getHeight() / 2);
    }
}
