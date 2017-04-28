package entities.creatures;
import graphics.Animation;
import graphics.Assets;
import game.Handler;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperMario extends Creature {

    //Animations
    private Animation animSuperMarioRight, animSuperMarioLeft;

    public SuperMario(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT);

        //Animations
        animSuperMarioRight = new Animation(70, Assets.superMarioRightMove);
        animSuperMarioLeft = new Animation(70, Assets.superMarioLeftMove);
        bounds.x = 4;
        bounds.y = -56;
        bounds.width = 56;
        bounds.height = 120;
    }

    @Override
    public void tick() {

        //Animations
        animSuperMarioRight.tick();
        animSuperMarioLeft.tick();

        //Movements
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().jump) {
            yMove = -speed * 3;
        }
        else {
            yMove += 8;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().run && handler.getKeyManager().right){
            xMove = speed*2;
        }
        if(handler.getKeyManager().run && handler.getKeyManager().left){
            xMove = -speed*2;
        }
        if(handler.getKeyManager().crouch){
            yMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        // Super Mario stay's in the same place.
        //g.setColor(Color.yellow);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        g.drawImage(getCurrentSuperMarioAnimationFrame(), (int) ((x-32) - handler.getGameCamera().getxOffset()), (int) (y-64), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
    }

    private BufferedImage getCurrentSuperMarioAnimationFrame(){
        if(yMove < 0 && xMove >= 0){
            return Assets.superMarioRightJump;
        }
        else if(yMove < 0 && xMove <= 0){
            return Assets.superMarioLeftJump;
        }
        // right crouch movement
        else if(handler.getKeyManager().crouch && xMove >= 0){
            return Assets.superMarioRightCrouch;
        }
        //left crouch movement
        else if(handler.getKeyManager().crouch && xMove <= 0){
            return Assets.superMarioLeftCrouch;
        }
        else if (xMove > 0){
            return animSuperMarioRight.getCurrentFrame();
        }
        else if (xMove < 0) {
            return animSuperMarioLeft.getCurrentFrame();
        }
        else{
            return Assets.superMarioRightNormal;
        }
    }
}
