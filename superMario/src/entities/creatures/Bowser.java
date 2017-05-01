package entities.creatures;
import game.Handler;
import graphics.Animation;
import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Bowser extends Creature{

    private Animation animBowserRight, animBowserLeft;
    private boolean spawned = false;

    public Bowser(Handler handler, float x, float y, int health){
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT, health);
        //Animations
        animBowserLeft = new Animation(100, Assets.bowserLeft);
        animBowserRight = new Animation(100, Assets.bowserRight);
        bounds.x = 8;
        bounds.y = 40;
        bounds.width = 120;
        bounds.height = 88;
    }

    @Override
    public void tick() {

        //if (handler.getWorld().getEntityManager().getMario().getX() - handler.getGameCamera().getxOffset()
        //== handler.getWidth() / 2 - Tile.TILEWIDTH / 2 || spawned)

        // If mario is at middle of screen tick enemy
        if (handler.getGameCamera().getxOffset() > 0 || spawned)
        {
        }
        //Animations
        animBowserRight.tick();
        animBowserLeft.tick();
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
            g.setColor(Color.RED);
            g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        }
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (checkEntityCollisions(0f, yMove))
        {
            return animBowserRight.getCurrentFrame();
        }
        else{
            return animBowserLeft.getCurrentFrame();
        }
    }

    private void getInput()
    {
        xMove = 0;
        enemyGravity();
        xMove = -speed + 2;
    }
}