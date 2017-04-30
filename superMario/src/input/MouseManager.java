package input;

import ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean LeftClick, RigthClick;
    private int mouseX, mouseY;
    private UIManager uiManager;

    public MouseManager()
    {

    }

    public void setUIManager(UIManager uiManager){
        this.uiManager = uiManager;
    }

    // GETTERS
    public boolean isLeftClick(){
        return LeftClick;
    }

    public boolean isRigthClick(){
        return RigthClick;
    }

    public int getMouseX(){
        return mouseX;
    }

    public int getMouseY(){
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getButton() == MouseEvent.BUTTON1){
            LeftClick = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            RigthClick = true;
        }

        if (uiManager != null){
            uiManager.onMouseReleas(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(e.getButton() == MouseEvent.BUTTON1){
            LeftClick = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            RigthClick = false;
        }

        if (uiManager != null){
            uiManager.onMouseReleas(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if (uiManager != null)
        {
            uiManager.onMouseMove(e);
        }

        mouseX = e.getX();
        mouseY = e.getY();
    }
}
