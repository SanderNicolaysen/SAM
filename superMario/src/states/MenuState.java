package states;
import entities.creatures.Creature;
import game.Handler;
import graphics.Assets;
import sounds.Sound;
import ui.UIImageButtons;
import ui.UIManager;
import ui.ClickListener;

import java.awt.*;


public class MenuState extends State {

    private ClickListener clickListener;
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        /*
*/
        // New Game
        uiManager.addObject(new UIImageButtons(handler.getWidth() / 2 - 305 / 2, handler.getHeight() / 2 - 80 / 2 + 200, 305, 80, Assets.resume, new ClickListener(){
            @Override
            public void onClick() {
                handler.getGame().resetGame();
                handler.getKeyManager().pause = false;
                State.setState(handler.getGame().gameState);
            }}));

        /*
        // Resume
        uiManager.addObject(new UIImageButtons(handler.getWidth() / 2 - 305 / 2, handler.getHeight() / 2 - 80 / 2 + 300, 305, 80, Assets., new ClickListener(){
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);

            }}));
            */

        // Quit
        uiManager.addObject(new UIImageButtons(handler.getWidth() / 2 - 305 / 2, handler.getHeight() / 2 - 80 / 2 + 300, 305, 80, Assets.quit, new ClickListener(){
            @Override
            public void onClick() {
                System.exit(0);
            }}));
    }

    @Override
    public void tick()
    {
        //System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());

        // pause is false as default
        // Do not switch to gameState before gameState is initialized
        if (!handler.getKeyManager().pause && handler.getGame().gameState != null)
        {
            State.setState(handler.getGame().gameState);
        }

        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.bg,0, 0, handler.getWidth(), handler.getHeight(), null);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1920, 1080);
        g.drawImage(Assets.menu[0], handler.getWidth() / 2 - (175 * 4) / 2, handler.getHeight() / 2 - (95*4), 175 * 4, 95 * 4, null);
        uiManager.render(g);
        //g.drawImage(Assets.marioDeath, (int) handler.getWorld().getEntityManager().getMario().getX(), (int) handler.getWorld().getEntityManager().getMario().getY() - 100, Creature.DEFAULT_16x16_WIDTH * 3, Creature.DEFAULT_16x16_HEIGHT * 3, null);
    }
}