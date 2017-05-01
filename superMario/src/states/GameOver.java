package states;

import game.Handler;
import entities.Entity;
import graphics.Animation;
import graphics.Assets;
import entities.creatures.Mario;
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

    }

    @Override
    public void render(Graphics g) {


            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 1920, 1080);
            g.setFont(new Font("marioFont", Font.BOLD, 60));
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", handler.getWidth() / 2 - 300, handler.getHeight() / 2);
            State.setState(handler.getGame().menuState);

           /*
            g.drawString("GAME OVER", handler.getWidth() / 2 - 300, handler.getHeight() / 2);
            Timer = 3000;
            State.setState(handler.getGame().menuState);
            */
        /*
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1920, 1080);
        g.setFont(new Font("marioFont", Font.BOLD, 60));
        g.setColor(Color.WHITE);
        g.drawString("GAME OVER", handler.getWidth() / 2 - 300, handler.getHeight() / 2);
        */
    }
}
