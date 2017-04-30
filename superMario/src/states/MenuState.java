package states;
import game.Handler;
import graphics.Assets;
import ui.UIImageButtons;
import ui.UIManager;
import ui.ClickListener;

import java.awt.*;


public class MenuState extends State{

    private ClickListener clickListener;
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButtons(handler.getWidth() / 2 - 305 / 2, handler.getHeight() / 2 - 80 / 2 + 200, 305, 80, Assets.play, new ClickListener(){
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);
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