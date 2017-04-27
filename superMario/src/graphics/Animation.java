package graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick(){
        // Time that has passed since last tick method.
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        // Time that has passed since last tick method must be greater than the speed for the animation.
        if(timer > speed){
            index++;
            timer = 0;
            // If index of array is larger than it's size reset it to zero.
            if(index >= frames.length)
                index = 0;
        }
    }
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

}
