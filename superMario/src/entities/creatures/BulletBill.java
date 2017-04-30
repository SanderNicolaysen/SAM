package entities.creatures;
import game.Handler;
import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;


public class BulletBill extends Creature{

    private boolean spawned = false;

    public BulletBill(Handler handler, float x, float y){
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT);
        //Animations
        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 56;
        bounds.height = 48;
    }

    @Override
    public void tick() {

        //if (handler.getWorld().getEntityManager().getMario().getX() - handler.getGameCamera().getxOffset()
        //== handler.getWidth() / 2 - Tile.TILEWIDTH / 2 || spawned)

        // If mario is at middle of screen tick enemy
        //if (handler.getGameCamera().getxOffset() > 0 || spawned)
       // {
       // }

        if (x - handler.getWorld().getEntityManager().getMario().getX() < handler.getWidth() / 2 || spawned)
        {
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
        //if (handler.getWorld().getEntityManager().getMario().getX() - handler.getGameCamera().getxOffset() == 928 || spawned)
        // If mario is at middle of screen render enemy
        //if (handler.getGameCamera().getxOffset() > 0 || spawned)
       // {
            //g.setColor(Color.RED);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        //}

        if (spawned)
        {
            g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_16x16_WIDTH, DEFAULT_16x16_HEIGHT, null);
        }

    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (checkEntityCollisions(0f, yMove))
        {
            return Assets.bulletBillRight;
        }
        else{
            return Assets.bulletBillLeft;
        }
    }

    private void getInput()
    {
        xMove = 0;
        xMove = -speed + 2;
    }
}