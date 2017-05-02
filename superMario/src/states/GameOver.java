package states;

import game.Handler;
import entities.Entity;
import graphics.Animation;
import graphics.Assets;
import entities.creatures.Mario;
import sounds.Sound;
import ui.UIImage;

import java.awt.*;
import java.awt.image.BufferedImage;

import static entities.creatures.Creature.DEFAULT_16x16_HEIGHT;
import static entities.creatures.Creature.DEFAULT_16x16_WIDTH;

public class GameOver extends State {

    private Animation marioDeath;
    private Mario mario;
    long Timer = System.currentTimeMillis();


    public GameOver(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        //ein pause før den går tilbake til meny

        System.out.println("he");

    }


    @Override
    public void render(Graphics g) {
        //gameover screen with points
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1920, 1080);
        g.setFont(new Font("marioFont", Font.BOLD, 60));
        g.setColor(Color.WHITE);
        g.drawString("GAME OVER", handler.getWidth() / 2 - 200, handler.getHeight() / 2 - 100);
        g.setFont(new Font("marioFont", Font.BOLD, 30));
        g.setColor(Color.WHITE);
        g.drawString("Score:  " + handler.getWorld().getEntityManager().getMario().getScore(),  handler.getWidth() / 2 - 100, handler.getHeight() / 2);
        //g.drawImage(Assets.marioDeath, (int) handler.getWorld().getEntityManager().getMario().getX(), (int) handler.getWorld().getEntityManager().getMario().getY(), null);


        try {
            handler.getSound().close();
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        State.setState(handler.getGame().menuState);
    }
}
