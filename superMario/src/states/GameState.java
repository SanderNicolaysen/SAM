package states;

import entities.creatures.SuperMario;
import game.Game;
import graphics.Assets;
import worlds.World;

import java.awt.*;

/**
 * The class for our GameState
 */
public class GameState extends State {

    private SuperMario supermario;
    private World world;

    // Constructor
    public GameState(Game game)
    {
        super(game);
        // (x, y): start position of SuperMario
        supermario = new SuperMario(game, 100, 100);
        world = new World(game, "res/worlds/world1.txt");
    }

    @Override
    public void tick()
    {
        world.tick();
        supermario.tick();
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
        supermario.render(g);
    }
}
