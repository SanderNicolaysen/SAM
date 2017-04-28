package entities.creatures;
import game.Handler;
import graphics.Animation;
import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FireMario extends Creature{

    //Animations
    private Animation animFireMarioRight, animFireMarioLeft;

    public FireMario(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT);

        animFireMarioRight = new Animation(70, Assets.fireMarioRightMove);
        animFireMarioLeft = new Animation(70, Assets.fireMarioLeftMove);
    }

    @Override
    public void tick() {
        //Animations
        animFireMarioRight.tick();
        animFireMarioLeft.tick();

        //Movements
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().jump) {
            yMove = -speed;
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
        g.drawImage(getCurrentFireMarioAnimationFrame(), (int) ((x-32) - handler.getGameCamera().getxOffset()), (int) (y-64), 128, 128, null);
    }

    private BufferedImage getCurrentFireMarioAnimationFrame(){
        if(yMove != 0 && xMove >= 0){
            return Assets.fireMarioRightJump;
        }
        else if(yMove != 0 && xMove <= 0){
            return Assets.fireMarioLeftJump;
        }
        else if(xMove >= 0 && handler.getKeyManager().throwFireBall){
            return Assets.fireMarioRightThrow;
        }
        else if(xMove <= 0 && handler.getKeyManager().throwFireBall){
            return Assets.fireMarioLeftThrow;
        }
        else if (handler.getKeyManager().crouch){
            return Assets.fireMarioRightCrouch;
        }
        else if (xMove > 0 && yMove == 0){
            return animFireMarioRight.getCurrentFrame();
        }
        else if (xMove < 0 && yMove == 0) {
            return animFireMarioLeft.getCurrentFrame();
        }
        else{
            return Assets.fireMarioRightNormal;
        }
    }
}
