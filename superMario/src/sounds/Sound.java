package sounds;

import game.Handler;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound
{
    Handler handler;

    public Sound(Handler handler)
    {
        handler = this.handler;
    }

    public static File marioJumpSound, bowserFireSound, jumpHitSound, fireBallSound, marioDieSound, gameOverSound, flagPoleSound, pauseSound,
            powerUpAppearSound, healthIncreaseSound, healthDecreaseSound, stageClearSound, boxHitSound, coinSound, overWorldTheme;

    public static void init()
    {
        overWorldTheme = new File("res/sounds & music/01-main-theme-overworld.wav");

        marioJumpSound = new File("res/sounds & music/smb_jump-super.wav");
        marioDieSound = new File("res/sounds & music/smb_mariodie.wav");
        jumpHitSound = new File("res/sounds & music/smb_stomp.wav");
        stageClearSound = new File("res/sounds & music/smb_stage_clear.wav");
        pauseSound = new File("res/sounds & music/smb_pause.wav");
        bowserFireSound = new File("res/sounds & music/smb_bowserfire.wav");
        fireBallSound = new File("res/sounds & music/smb_fireball.wav");
        gameOverSound = new File("res/sounds & music/smb_gameover.wav");
        flagPoleSound = new File("res/sounds & music/smb_flagpole.wav");
        powerUpAppearSound = new File("res/sounds & music/smb_powerup_appears.wav");
        healthIncreaseSound = new File("res/sounds & music/smb_powerup.wav");
        healthDecreaseSound = new File("res/sounds & music/smb_pipe.wav");
        boxHitSound = new File("res/sounds & music/smb_bump.wav");
        coinSound = new File("res/sounds & music/smb_coin.wav");

    }


    private Clip clip;

    public void playSound(File sound)
    {
        try
        {
            try
            {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(sound));
                clip.start();
                //Thread.sleep(clip.getMicrosecondLength() / 1000);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (UnsupportedAudioFileException e)
            {
                e.printStackTrace();
            }

        }
        catch (LineUnavailableException e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        stop();
        clip.close();
        System.out.println("Test close");
    }

    public void stop()
    {
        if (clip.isRunning())
        {
            System.out.println("sound Test");
            clip.stop();
        }
    }
}
