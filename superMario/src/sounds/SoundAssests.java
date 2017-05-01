package sounds;

public class SoundAssests {

    public static Sound marioJumpSound, bowserFireSound, jumpHitSound, fireBallSound, marioDieSound, gameOverSound, flagPoleSound, pauseSound,
            powerUpAppearSound, healthIncreaseSound, healthDecreaseSound, stageClearSound, boxHitSound, coinSound;

    public static void init(){

        marioJumpSound = new Sound("res/sounds & music/smb_jump-small.wav");
        bowserFireSound = new Sound("res/sounds & music/smb_bowserfire.wav");
        jumpHitSound = new Sound("res/sounds & music/smb_stomp.wav");
        fireBallSound = new Sound("res/sounds & music/smb_fireball.wav");
        marioDieSound = new Sound("res/sounds & music/smb_mariodie.wav");
        gameOverSound = new Sound("res/sounds & music/smb_gameover.wav");
        flagPoleSound = new Sound("res/sounds & music/smb_flagpole.wav");
        pauseSound = new Sound("res/sounds & music/smb_pause.wav");
        powerUpAppearSound = new Sound("res/sounds & music/smb_powerup_appears.wav");
        healthIncreaseSound = new Sound("res/sounds & music/smb_powerup.wav");
        healthDecreaseSound = new Sound("res/sounds & music/smb_pipe.wav");
        stageClearSound = new Sound("res/sounds & music/smb_stage_clear.wav");
        boxHitSound = new Sound("res/sounds & music/smb_bump.wav");
        coinSound = new Sound("res/sounds & music/smb_coin.wav");
    }
}
