package entities.creatures;
import game.Handler;
import graphics.Animation;
import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Goomba extends Creature{

    private Animation animGoombaMovement, animGoombaDeath, animGoombaJumpDeath;
    private boolean spawned = false;

    public Goomba(Handler handler, float x, float y, int health){
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT, health);
        //Animations
        animGoombaMovement = new Animation(200, Assets.goombaMovement);
        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 56;
        bounds.height = 48;
    }

    @Override
    public void tick() {

        if (x - handler.getWorld().getEntityManager().getMario().getX() < handler.getWidth() / 2 || spawned)
        {
            //Animations
            animGoombaMovement.tick();
            //Movements
            getInput();
            move();

            spawned = true;
        }
        //System.out.println(x - handler.getWorld().getEntityManager().getMario().getX() + "   " + handler.getWidth() / 2);
    }

    @Override
    public void render(Graphics g)
    {
        if (spawned)
        {
            //g.setColor(Color.RED);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
            g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_16x16_WIDTH, DEFAULT_16x16_HEIGHT, null);
        }
    }

    @Override
    public void die() {

    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (checkEntityCollisions(0f, yMove))
        {
            return animGoombaMovement.getCurrentFrame();
        }
        else if (xMove == 0) {
            return Assets.goombaJumpDeath;
        }
        else{
            return animGoombaMovement.getCurrentFrame();
        }
    }

    private float temp = 0;
    Double increment = 3.14 / (60 * 2);
    private void getInput()
    {
        xMove = 0;
        enemyGravity();

        if (temp == 3.14)
        {
            temp = 0;
        }

        temp += increment;
        xMove = (float) Math.sin(temp) * 8;
    }
}
