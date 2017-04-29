package entities.creatures;

import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.DoubleSummaryStatistics;

public class GreenKoopaTroopa extends Creature {

    private Animation animKoopaRight, animKoopaLeft;

    public GreenKoopaTroopa(Handler handler, float x, float y)
    {
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT);

        animKoopaRight = new Animation(200, Assets.greenKoopaTroopaRight);
        animKoopaLeft = new Animation(200, Assets.greenKoopaTroopaLeft);

        bounds.x = 44;
        bounds.y = 66;
        bounds.width = 48;
        bounds.height = 61;
    }

    @Override
    public void tick()
    {
        animKoopaRight.tick();
        animKoopaLeft.tick();

        getInput();
        move();
    }

    @Override
    public void render(Graphics g)
    {
        //g.setColor(Color.RED);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        //return animKoopaRight.getCurrentFrame();
        return animKoopaLeft.getCurrentFrame();
    }

    //private float temp = 0;
    //Double increment = 3.14 / (60 * 4);
    private void getInput()
    {
        xMove = 0;
        yMove = 0;

        xMove = -speed + 2;
        yMove = speed;

        //temp -= increment;
        //xMove = (float) Math.sin(temp) * 4;
        //yMove = (float) Math.cos(temp) * 5;
    }

}
