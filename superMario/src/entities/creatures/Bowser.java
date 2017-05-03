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
        bounds.x = 156;
        bounds.y = 64;
        bounds.width = 190;
        bounds.height = 320;
    }

    @Override
    public void tick() {

        // If mario is at middle of screen tick enemy
        if (x - handler.getWorld().getEntityManager().getMario().getX() < handler.getWidth() / 2 || spawned)
        {
            //Animations
            animBowserRight.tick();
            animBowserLeft.tick();
            //Movements
            getInput();
            move();

            spawned = true;
        }
    }

    @Override
    public void render(Graphics g)
    {
        if (spawned)
        {
            //g.setColor(Color.RED);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
            g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_32x32_WIDTH * 3, DEFAULT_32x32_HEIGHT * 3, null);
        }
    }

    @Override
    public void die() {

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

    private float temp = 0;
    Double increment = 3.14 / (60 * 2);
    private void getInput()
    {
        xMove = 0;

        bowserGravity();

        if (temp == 3.14)
        {
            temp = 0;
        }

        temp += increment;
        xMove = (float) Math.sin(temp) * 12;

    }
}