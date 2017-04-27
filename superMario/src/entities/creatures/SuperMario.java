package entities.creatures;

import graphics.Animation;
import graphics.Assets;
import game.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperMario extends Creature {

    //Animations

    private Animation animMarioRight, animMarioLeft, animSuperMarioRight, animSuperMarioLeft, animFireMarioRight, animFireMarioLeft;

    public SuperMario(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_MARIO_WIDTH, Creature.DEFAULT_MARIO_HEIGHT);

        // Bounding box for player
        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        //Animations
        animMarioRight = new Animation(70, Assets.marioRightMove);
        animMarioLeft = new Animation(70, Assets.marioLeftMove);
        animSuperMarioRight = new Animation(70, Assets.superMarioRightMove);
        animSuperMarioLeft = new Animation(70, Assets.superMarioLeftMove);
        animFireMarioRight = new Animation(70, Assets.fireMarioRightMove);
        animFireMarioLeft = new Animation(70,Assets.fireMarioLeftMove);
    }

    @Override
    public void tick() {

        //Animations
        animMarioRight.tick();
        animMarioLeft.tick();
        animSuperMarioRight.tick();
        animSuperMarioLeft.tick();
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

        // If jump == true do this
        if(handler.getKeyManager().jump) {
            yMove = -speed * 3;
            //Pål, do your thing...
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

        //temp += 3.14/60;
        //yMove = (float)Math.sin(temp) * 10;
        //xMove = (float)Math.cos(temp) * 10;

    }

    @Override
    public void render(Graphics g) {
        // Super Mario stay's in the same place.
        g.drawImage(getCurrentMarioAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), width, height, null);
        //g.setColor(Color.RED);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        //g.drawImage(getCurrentSuperMarioAnimationFrame(), (int) ((x-32) - handler.getGameCamera().getxOffset()), (int) (y-64), 128, 128, null);
        //g.drawImage(getCurrentFireMarioAnimationFrame(), (int) ((x-32) - handler.getGameCamera().getxOffset()), (int) (y-64), 128, 128, null);
    }

    private BufferedImage getCurrentMarioAnimationFrame() {
        // right jump movement
        if(yMove < 0 && xMove >= 0){
            return Assets.marioRightJump;
        }
        // left jump movement
        else if(yMove < 0 && xMove <= 0){
            return Assets.marioLeftJump;
        }
        // right movement
        else if (xMove > 0){
            return animMarioRight.getCurrentFrame();
        }
        // left movement
        else if (xMove < 0) {
            return animMarioLeft.getCurrentFrame();
        }
        // Mario default right
        else {
            return Assets.marioRightNormal;
        }
    }

    private BufferedImage getCurrentSuperMarioAnimationFrame(){
        if(yMove < 0 && xMove >= 0){
            return Assets.superMarioRightJump;
        }
        else if(yMove < 0 && xMove <= 0){
            return Assets.superMarioLeftJump;
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
    private BufferedImage getCurrentFireMarioAnimationFrame(){
        if(yMove < 0 && xMove >= 0){
            return Assets.fireMarioRightJump;
        }
        else if(yMove < 0 && xMove <= 0){
            return Assets.fireMarioLeftJump;
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
    //private BufferedImage getCurrentSuperMarioAnimationFrame(){}
    //private BufferedImage getCurrentFireMarioAnimationFrame(){}
}
