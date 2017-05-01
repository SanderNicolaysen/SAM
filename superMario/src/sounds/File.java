/*
package sounds;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class File
{

    public File(String s)
    {

    }

    public static void init()
    {
        File marioJumpSound = new File("res/sounds & music/smb_jump-small.wav");

        /*java.io.File bowserFireSound = new File("res/sounds & music/smb_bowserfire.wav");
        java.io.File jumpHitSound = new File("res/sounds & music/smb_stomp.wav");
        java.io.File fireBallSound = new File("res/sounds & music/smb_fireball.wav");
        java.io.File marioDieSound = new File("res/sounds & music/smb_mariodie.wav");
        java.io.File gameOverSound = new File("res/sounds & music/smb_gameover.wav");
        java.io.File flagPoleSound = new File("res/sounds & music/smb_flagpole.wav");
        java.io.File pauseSound = new File("res/sounds & music/smb_pause.wav");
        java.io.File powerUpAppearSound = new File("res/sounds & music/smb_powerup_appears.wav");
        java.io.File healthIncreaseSound = new File("res/sounds & music/smb_powerup.wav");
        java.io.File healthDecreaseSound = new File("res/sounds & music/smb_pipe.wav");
        java.io.File stageClearSound = new File("res/sounds & music/smb_stage_clear.wav");
        java.io.File boxHitSound = new File("res/sounds & music/smb_bump.wav");
        java.io.File coinSound = new File("res/sounds & music/smb_coin.wav");

    }


    static void playSound(File sound)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (LineUnavailableException e)
        {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    public void play(){
        if(clip == null)
            return;
        stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public void close(){
        stop();
        clip.close();
    }

    public void stop(){
        if(clip.isRunning())
            clip.stop();
    }

}
*/
