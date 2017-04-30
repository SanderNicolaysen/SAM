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
        bounds.x = 4;
        bounds.y = -56;
        bounds.width = 56;
        bounds.height = 120;
    }

    @Override
    public void tick() {
        //Animations
        animFireMarioRight.tick();
        animFireMarioLeft.tick();

        //Movements
        getInput();
        handler.getGameCamera().centerOnEntity(this);

        if(!checkEntityCollisionPlayer(xMove, 0f))
            moveX();
        if(!checkEntityCollisionPlayer(0f, yMove)){
            moveY();
        }
    }
    private void getInput() {
        xMove = 0;
        playerGravity();

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
            xMove = 0;
        }

    }

    @Override
    public void render(Graphics g) {
        // Super Mario stay's in the same place.
        g.drawImage(getCurrentFireMarioAnimationFrame(), (int) ((x-32) - handler.getGameCamera().getxOffset()), (int) (y-64), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
    }

    private BufferedImage getCurrentFireMarioAnimationFrame(){
        if(jumping && xMove >= 0){
            return Assets.fireMarioRightJump;
        }
        else if(jumping && xMove <= 0){
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
        else if (xMove > 0){
            return animFireMarioRight.getCurrentFrame();
        }
        else if (xMove < 0) {
            return animFireMarioLeft.getCurrentFrame();
        }
        else{
            return Assets.fireMarioRightNormal;
        }
    }
}
