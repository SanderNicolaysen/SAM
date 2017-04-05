package states;

import enteties.SuperMario;
import game.Game;
import graphics.Assets;

import java.awt.*;

public class GameState extends State{

    private SuperMario superMario;

    public GameState(Game game) {
        super(game);
        superMario = new SuperMario(game, 100, 100);
    }
    @Override
    public void tick(){
        superMario.tick();
    }

    @Override
    public void render(Graphics g) {
        superMario.render(g);
    }

}
