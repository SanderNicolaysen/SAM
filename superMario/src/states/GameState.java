package states;

import enteties.SuperMario;
import game.Game;
import graphics.Assets;
import java.awt.*;

/**
 * The class for our GameState
 */
public class GameState extends State {

    private SuperMario supermario;

    // Constructor
    public GameState(Game game)
    {
        super(game);
        supermario = new SuperMario(game, 100, 100);
    }

    int x = 0;
    @Override
    public void tick()
    {
        supermario.tick();
    }

    @Override
    public void render(Graphics g)
    {
        supermario.render(g);

        g.setColor(Color.CYAN.darker());
        g.fillRect(0, 0, 900, 700);

        g.setColor(Color.GREEN.darker());
        g.fillRect(0, 600, 900, 100);
    }
}
