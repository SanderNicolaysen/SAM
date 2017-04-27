package input;

import states.State;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean jump, run, right, left, crouch;
    public boolean enter = false;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        jump = keys[KeyEvent.VK_SPACE];
        run = keys[KeyEvent.VK_SHIFT];
        right = keys[KeyEvent.VK_RIGHT];
        left = keys[KeyEvent.VK_LEFT];
        crouch = keys[KeyEvent.VK_DOWN];
    }

    @Override
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enter = !enter;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }
    @Override
    public void keyTyped(KeyEvent e){
    }

}
