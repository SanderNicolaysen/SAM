package entities.creatures;


import entities.Entity;
import game.Handler;
import graphics.Animation;
import graphics.Assets;
import states.State;
import tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mario extends Creature {

    //Animations
    private Animation animMarioRight, animMarioLeft, animSuperMarioRight, animSuperMarioLeft, animFireMarioRight, animFireMarioLeft;

    public Mario(Handler handler, float x, float y, int health) {
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT, health);

        if (health >= 3){
            health = 3;
        }
        if (health <= 0){
            health = 0;
        }
        if (health <= 1) {
            animMarioRight = new Animation(70, Assets.marioRightMove);
            animMarioLeft = new Animation(70, Assets.marioLeftMove);
            bounds.x = 4;
            bounds.y = 4;
            bounds.width = 60;
            bounds.height = 60;
        }
        if (health == 2) {
            animSuperMarioRight = new Animation(70, Assets.superMarioRightMove);
            animSuperMarioLeft = new Animation(70, Assets.superMarioLeftMove);
            bounds.x = 4;
            bounds.y = -56;
            bounds.width = 56;
            bounds.height = 120;
        }
        if (health == 3){
            animFireMarioRight = new Animation(70, Assets.fireMarioRightMove);
            animFireMarioLeft = new Animation(70, Assets.fireMarioLeftMove);
            bounds.x = 4;
            bounds.y = -56;
            bounds.width = 56;
            bounds.height = 120;
        }
    }

    @Override
    public void tick()
    {
        //Animations
        if(health == 1) {
            animMarioRight.tick();
            animMarioLeft.tick();
        }
        else if(health == 2){
            animSuperMarioRight.tick();
            animSuperMarioLeft.tick();
        }
        else if(health == 3){
            animFireMarioRight.tick();
            animFireMarioLeft.tick();
        }
        //Movements
        getInput();
        if(!checkEntityCollisionPlayer(xMove, 0f))
            moveX();
        if(!checkEntityCollisionPlayer(0f, yMove))
            moveY();

        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        playerGravity();

        if(health != 0)
        {

            if (handler.getKeyManager().right)
            {
                xMove = speed;
            }
            if (handler.getKeyManager().left && x > 0)
            {
                xMove = -speed;
            }
            if (handler.getKeyManager().run && handler.getKeyManager().right)
            {
                xMove = speed * 2;
            }
            if (handler.getKeyManager().run && handler.getKeyManager().left && x > 0)
            {
                xMove = -speed * 2;
            }
        }
        else
        {
            if (yMove == 0)
            {
                //health = 1;
                //x = 150;
                //y = 888;
                //handler.getWorld().getEntityManager().getEntities().clear();
                State.setState(handler.getGame().gameOver);
            }
            yMove += 10;
        }

        if (y > handler.getHeight())
        {
            State.setState(handler.getGame().gameOver);
        }
    }

    @Override
    public void render(Graphics g) {
        if(health <= 1) {
            //g.setColor(Color.yellow);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
            g.drawImage(getCurrentMarioAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_16x16_WIDTH, DEFAULT_16x16_HEIGHT, null);
        }
        else if(health == 2) {
            //g.setColor(Color.yellow);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
            g.drawImage(getCurrentSuperMarioAnimationFrame(), (int) ((x-32) - handler.getGameCamera().getxOffset()), (int) (y-64), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
        }
        else if(health == 3){
            //g.setColor(Color.yellow);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
            g.drawImage(getCurrentFireMarioAnimationFrame(), (int) ((x-32) - handler.getGameCamera().getxOffset()), (int) (y-64), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
        }
    }

    private BufferedImage getCurrentMarioAnimationFrame() {
        if (health <= 0){
            return Assets.marioDeath;
        }
        // right jump movement
        if (jumping && xMove >= 0 && handler.getKeyManager().direction){
            return Assets.marioRightJump;
        }
        // left jump movement
        else if (jumping && xMove <= 0 && !handler.getKeyManager().direction){
            return Assets.marioLeftJump;
        }
        // right movement
        else if (xMove > 0)
        {
            return animMarioRight.getCurrentFrame();
        }
        // left movement
        else if (xMove < 0)
        {
            return animMarioLeft.getCurrentFrame();
        }
        // default direction
        else
        {
            if (handler.getKeyManager().direction) {
                return Assets.marioRightNormal;
            }
            else {
                return Assets.marioLeftNormal;
            }
        }
    }
    private BufferedImage getCurrentSuperMarioAnimationFrame(){
        if(jumping && xMove >= 0){
            return Assets.superMarioRightJump;
        }
        else if(jumping && xMove <= 0){
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
