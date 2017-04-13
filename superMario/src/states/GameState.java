package states;

import entities.creatures.SuperMario;
import game.Game;
import graphics.Assets;
import tiles.Tile;

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
        // (x, y): start position of SuperMario
        supermario = new SuperMario(game, 100, 100);
    }

    @Override
    public void tick()
    {
        supermario.tick();
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.CYAN.darker());
        g.fillRect(0, 0, 900, 700);

        g.setColor(Color.GREEN.darker());
        g.fillRect(0, 600, 900, 100);

        supermario.render(g);
        Tile.tiles[0].render(g, 0, 0);
    }
}
