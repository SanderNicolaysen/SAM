
package states;

import game.Handler;
import graphics.Assets;
import ui.UIImageButtons;
import ui.UIManager;
import ui.ClickListener;

import java.awt.*;


/**
 * The class for our menuState
 */

public class MenuState extends State{

    private ClickListener clickListener;
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);

        uiManager.addObject(new UIImageButtons(940, 540, 305, 80, Assets.play, new ClickListener(){
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);
            }}));
    }

    @Override
    public void tick() {
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        uiManager.render(g);
        g.fillRect(0,0,1920,1080);

    }
}