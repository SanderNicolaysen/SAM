package states;

import game.Handler;
import graphics.Assets;
import ui.ClickListener;
import ui.UIImageButtons;
import ui.UIManager;
import states.MenuState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PauseState extends State{
    private ClickListener clickListener;
    private UIManager uiManager;
    private MenuState menuState;

    public PauseState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        // Continue
        uiManager.addObject(new UIImageButtons(handler.getWidth() / 2 - 305 / 2, handler.getHeight() / 2 - 80 / 2 + 200, 305, 80, Assets.resume, new ClickListener(){
            @Override
            public void onClick() {
                handler.getKeyManager().pause = false;
                State.setState(handler.getGame().gameState);
            }}));
        // Exit to menu
        uiManager.addObject(new UIImageButtons(handler.getWidth() / 2 - 305 / 2, handler.getHeight() / 2 - 80 / 2 + 300, 305, 80, Assets.exittomenu, new ClickListener(){
            @Override
            public void onClick() {
                State.setState(handler.getGame().menuState);
            }}));
        // Desktop
        uiManager.addObject(new UIImageButtons(handler.getWidth() / 2 - 305 / 2, handler.getHeight() / 2 - 80 / 2 + 400, 305, 80, Assets.exittodesktop, new ClickListener(){
            @Override
            public void onClick() {
                System.exit(0);
            }}));
    }

    @Override
    public void tick()
    {
        //System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.bg,0, 0, handler.getWidth(), handler.getHeight(), null);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1920, 1080);
        g.drawImage(Assets.menu[0], handler.getWidth() / 2 - (175 * 4) / 2, handler.getHeight() / 2 - (95*4), 175 * 4, 95 * 4, null);
        uiManager.render(g);
    }
}