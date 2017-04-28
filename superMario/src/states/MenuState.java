package states;

import entities.creatures.Mario;
import entities.creatures.SuperMario;
import game.Handler;
import graphics.Assets;
import ui.UIImage;
import ui.UIManager;
import worlds.World;

import java.awt.*;

/**
 * The class for our menuState
 */
public class MenuState extends State
{
    private UIManager uiManager;
    private World world;
    private Mario mario;

    // Constructor
    public MenuState(Handler handler)
    {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
        mario = new Mario(handler, 150, 1080 - 64 * 3);

        uiManager = new UIManager(handler);

        uiManager.addObject(new UIImage(handler.getWidth() / 2 - (175 * 3)/2, handler.getHeight() / 2 - (87 * 3), 175 * 3, 87 * 3, Assets.menu));
    }

    @Override
    public void tick()
    {
        if (handler.getKeyManager().enter)
        {
            State.setState(handler.getGame().gameState);
        }

        mario.tick();
        uiManager.tick();
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bg,0, 0, 1920, 1080, null);
        world.render(g);
        uiManager.render(g);
        mario.render(g);
    }
}
