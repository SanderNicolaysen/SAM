package entities.creatures;
import game.Handler;
import graphics.Animation;
import graphics.Assets;
import tiles.Tile;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.DoubleSummaryStatistics;

public class RedKoopaTroopa extends Creature {

    private Animation animRedKoopaRight, animRedKoopaLeft;
    private boolean spawned = false;

    public RedKoopaTroopa(Handler handler, float x, float y)
    {
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT);

        animRedKoopaRight = new Animation(200, Assets.redKoopaTroopaRight);
        animRedKoopaLeft = new Animation(200, Assets.redKoopaTroopaLeft);

        bounds.x = 40;
        bounds.y = 80;
        bounds.width = 48;
        bounds.height = 48;
    }

    @Override
    public void tick()
    {
        //if (handler.getWorld().getEntityManager().getMario().getX() - handler.getGameCamera().getxOffset()
        //== handler.getWidth() / 2 - Tile.TILEWIDTH / 2 || spawned)

        // If mario is at middle of screen tick enemy
        if (handler.getGameCamera().getxOffset() > 0 || spawned)
        {
        }

        //Animations
        animRedKoopaRight.tick();
        animRedKoopaLeft.tick();
        //Movements
        getInput();
        move();

        spawned = true;
    }

    @Override
    public void render(Graphics g)
    {
        //if (handler.getWorld().getEntityManager().getMario().getX() - handler.getGameCamera().getxOffset() == 928 || spawned)
        // If mario is at middle of screen render enemy
        if (handler.getGameCamera().getxOffset() > 0 || spawned)
        {
            //g.setColor(Color.RED);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        }
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (checkEntityCollisions(0f, yMove))
        {
            return animRedKoopaRight.getCurrentFrame();
        }
        else
        {
            return animRedKoopaLeft.getCurrentFrame();
        }

    }

    private void getInput()
    {
        xMove = 0;
        enemyGravity();

        xMove = -speed + 2;
    }
}