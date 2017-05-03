package graphics;

import java.awt.image.BufferedImage;

/**
 *
 * This class will load inn all of our assets (Textures, images, sounds etc).
 */
public class Assets
{
    private static final int width16 = 16, height16 = 16, width32 = 32, height32 = 32;

    // Different tiles/images that will be equal to cropped out pictures of our sprite sheet.

    //All Mario tiles/images
    public static BufferedImage marioRightNormal, marioRightJump, marioLeftNormal, marioLeftJump, marioDeath,
            superMarioRightNormal, superMarioRightCrouch, superMarioRightJump, superMarioLeftNormal, superMarioLeftCrouch, superMarioLeftJump,
            fireMarioRightNormal, fireMarioRightJump, fireMarioRightCrouch, fireMarioRightThrow, fireMarioLeftNormal, fireMarioLeftJump, fireMarioLeftCrouch, fireMarioLeftThrow;
    public static BufferedImage[] marioRightMove;
    public static BufferedImage[] marioLeftMove;
    public static BufferedImage[] superMarioRightMove;
    public static BufferedImage[] superMarioLeftMove;
    public static BufferedImage[] fireMarioRightMove;
    public static BufferedImage[] fireMarioLeftMove;
    public static BufferedImage[] fireBall;
    public static BufferedImage[] fireBallHit;

    //All enemy tiles/images
    public static BufferedImage greenKoopaTroopaShell, greenKoopaTroopaDeath, redKoopaTroopaShell, redKoopaTroopaDeath, goombaDeath, goombaJumpDeath,
            bulletBillRight, bulletBillLeft, bulletBillCanon;
    public static BufferedImage[] greenKoopaTroopaRight;
    public static BufferedImage[] greenKoopaTroopaLeft;
    public static BufferedImage[] flyingGreenKoopaTroopaRight;
    public static BufferedImage[] flyingGreenKoopaTroopaLeft;
    public static BufferedImage[] redKoopaTroopaRight;
    public static BufferedImage[] redKoopaTroopaLeft;
    public static BufferedImage[] flyingRedKoopaTroopaRight;
    public static BufferedImage[] flyingRedKoopaTroopaLeft;
    public static BufferedImage[] goombaMovement;
    public static BufferedImage[] hammerBrotherRight;
    public static BufferedImage[] hammerBrotherLeft;
    public static BufferedImage[] hammerThrownRight;
    public static BufferedImage[] hammerThrownLeft;
    public static BufferedImage[] lakitu;
    public static BufferedImage[] beetleThrownDown;
    public static BufferedImage[] beetleRight;
    public static BufferedImage[] beetleLeft;
    public static BufferedImage[] piranhaPlant;
    public static BufferedImage[] bowserRight;
    public static BufferedImage[] bowserLeft;
    public static BufferedImage[] bowserFireRight;
    public static BufferedImage[] bowserFireLeft;

    //All items, objects and level design tiles/images
    public static BufferedImage grid, threeTopLeft, threeTopMiddle, threeTopRight, threeWood, mushroomTopLeft, mushroomTopMiddle, mushroomTopRight, mushroomStemTop, mushroomStemElse,
            castleFlag, levelPlatform1, levelPlatform2, levelPlatform3, levelPlatform4, levelPlatform5, levelPlatform6, redMushroom, greenMushroom,
            mushroomPowerUp, extraLifePowerUp, finishFlag, water, lava, singleCloud1, singleCloud2, singleCloud3, singleCloud4, smallThree1, smallThree2, tubeLeft1, tubeLeft2, tubeLeft3, tubeLeft4,tubeUp1, tubeUp2, tubeUp3, tubeUp4,
            tubeMiddle1, tubeMiddle2, tubeMiddle3, tubeMiddle4, tubeCore1, tubeCore2, tubeCore3, tubeCore4, tubeDown1, tubeDown2, tubeDown3, tubeDown4, toad1, toad2, peach1, peach2,
            skyBackground, waterBackground, lavaBackground, blackBackground, castleGateOpen1, castleGateOpen2, castleGateOpen3, castleGateOpen4, doubleCloud1, doubleCloud2, doubleCloud3, doubleCloud4, doubleCloud5, doubleCloud6,
            smallHill1, smallHill2, smallHill3, smallHill4, smallHill5, smallHill6, tripleCloud1, tripleCloud2, tripleCloud3, tripleCloud4, tripleCloud5, tripleCloud6, tripleCloud7, tripleCloud8, bigThree1, bigThree2, bigThree3,
            bigHill1, bigHill2, bigHill3, bigHill4, bigHill5, bigHill6, bigHill7, bigHill8, bigHill9, bigHill10, bigHill11, bigHill12, bigHill13, bigHill14, bigHill15,
            smallCastle1, smallCastle2, smallCastle3, smallCastle4, smallCastle5, smallCastle6, smallCastle7, smallCastle8, smallCastle9, smallCastle10, smallCastle11, smallCastle12, smallCastle13, smallCastle14, smallCastle15, smallCastle16, smallCastle17, smallCastle18, smallCastle19, smallCastle20, smallCastle21, smallCastle22, smallCastle23, smallCastle24, smallCastle25,
            emptyFlagPole, topFlagPole, bottomFlagPole;
    public static BufferedImage[] fireFlower;
    public static BufferedImage[] star;
    public static BufferedImage[] coin;
    public static BufferedImage[] boxCoin;
    public static BufferedImage[] questionBox;
    public static BufferedImage[] axe;
    public static BufferedImage[] flagPole;

    //All level design tiles/images
    public static BufferedImage ground, bg;
    public static BufferedImage[] menu;


    //All menu images
    public static BufferedImage[] play, quit, resume, exittomenu, exittodesktop, newGame;

    /**
     * This method will load in all the assets we need in our game.
     * It will only run once, so we don't have to crop out images several times.
     */
    public static void init()
    {
        SpriteSheet superMarioSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/MarioSprites.png"));
        //Mario's movements
        marioRightNormal = superMarioSheet.crop(width16*4, height16, width16, height16);
        marioRightJump = superMarioSheet.crop(0, height16, width16, height16);
        marioRightMove = new BufferedImage[4];
        marioRightMove[0] = superMarioSheet.crop(width16*3, height16, width16, height16);
        marioRightMove[1] = superMarioSheet.crop(width16*2, height16, width16, height16);
        marioRightMove[2] = superMarioSheet.crop(width16, height16, width16, height16);
        marioRightMove[3] = superMarioSheet.crop(width16*2, height16, width16, height16);
        marioDeath = superMarioSheet.crop(width16*5, 0, width16, height16);
        marioLeftNormal = superMarioSheet.crop(width16*4, 0, width16, height16);
        marioLeftJump = superMarioSheet.crop(0, 0, width16, height16);
        marioLeftMove = new BufferedImage[4];
        marioLeftMove[0] = superMarioSheet.crop(width16*3, 0, width16, height16);
        marioLeftMove[1] = superMarioSheet.crop(width16*2, 0, width16, height16);
        marioLeftMove[2] = superMarioSheet.crop(width16, 0, width16, height16);
        marioLeftMove[3] = superMarioSheet.crop(width16*2, 0, width16, height16);

        //Super Mario's movements
        superMarioRightNormal = superMarioSheet.crop(width32*4, height32*2, width32, height32);
        superMarioRightJump = superMarioSheet.crop(0, height32*2, width32, height32);
        superMarioRightCrouch = superMarioSheet.crop(width32*5, height32*2, width32, height32);
        superMarioRightMove = new BufferedImage[4];
        superMarioRightMove[0] = superMarioSheet.crop(width32*3, height32*2, width32, height32);
        superMarioRightMove[1] = superMarioSheet.crop(width32*2, height32*2, width32, height32);
        superMarioRightMove[2] = superMarioSheet.crop(width32, height32*2, width32, height32);
        superMarioRightMove[3] = superMarioSheet.crop(width32*2, height32*2, width32, height32);
        superMarioLeftNormal = superMarioSheet.crop(width32*4, height32, width32, height32);
        superMarioLeftJump = superMarioSheet.crop(0, height32, width32, height32);
        superMarioLeftCrouch = superMarioSheet.crop(width32*5, height32, width32, height32);
        superMarioLeftMove = new BufferedImage[4];
        superMarioLeftMove[0] = superMarioSheet.crop(width32*3, height32, width32, height32);
        superMarioLeftMove[1] = superMarioSheet.crop(width32*2, height32, width32, height32);
        superMarioLeftMove[2] = superMarioSheet.crop(width32, height32, width32, height32);
        superMarioLeftMove[3] = superMarioSheet.crop(width32*2, height32, width32, height32);

        //Fire Mario's movements
        fireMarioRightNormal = superMarioSheet.crop(width32*4, height32*4, width32, height32);
        fireMarioRightJump = superMarioSheet.crop(0, height32*4, width32, height32);
        fireMarioRightCrouch = superMarioSheet.crop(width32*5, height32*4, width32, height32);
        fireMarioRightThrow = superMarioSheet.crop(width32*6, height32*4, width32, height32);
        fireMarioRightMove = new BufferedImage[4];
        fireMarioRightMove[0] = superMarioSheet.crop(width32*3, height32*4, width32, height32);
        fireMarioRightMove[1] = superMarioSheet.crop(width32*2, height32*4, width32, height32);
        fireMarioRightMove[2] = superMarioSheet.crop(width32, height32*4, width32, height32);
        fireMarioRightMove[3] = superMarioSheet.crop(width32*2, height32*4, width32, height32);
        fireMarioLeftNormal = superMarioSheet.crop(width32*4, height32*3, width32, height32);
        fireMarioLeftJump = superMarioSheet.crop(0, height32*3, width32, height32);
        fireMarioLeftCrouch = superMarioSheet.crop(width32*5, height32*3, width32, height32);
        fireMarioLeftThrow = superMarioSheet.crop(width32*6, height32*3, width32, height32);
        fireMarioLeftMove = new BufferedImage[4];
        fireMarioLeftMove[0] = superMarioSheet.crop(width32*3, height32*3, width32, height32);
        fireMarioLeftMove[1] = superMarioSheet.crop(width32*2, height32*3, width32, height32);
        fireMarioLeftMove[2] = superMarioSheet.crop(width32, height32*3, width32, height32);
        fireMarioLeftMove[3] = superMarioSheet.crop(width32*2, height32*3, width32, height32);

        //Fire ball movements
        fireBall = new BufferedImage[4];
        fireBall[0] = superMarioSheet.crop(width16*6, 0, width16, height16);
        fireBall[1] = superMarioSheet.crop(width16*7, 0, width16, height16);
        fireBall[2] = superMarioSheet.crop(width16*8, 0, width16, height16);
        fireBall[3] = superMarioSheet.crop(width16*9, 0, width16, height16);
        fireBallHit = new BufferedImage[5];
        fireBallHit[0] = superMarioSheet.crop(width16*10, 0, width16, height16);
        fireBallHit[1] = superMarioSheet.crop(width16*11, 0, width16, height16);
        fireBallHit[2] = superMarioSheet.crop(width16*12, 0, width16, height16);
        fireBallHit[3] = superMarioSheet.crop(width16*11, 0, width16, height16);
        fireBallHit[4] = superMarioSheet.crop(width16*10, 0, width16, height16);

        SpriteSheet enemySheet = new SpriteSheet(ImageLoader.loadImage("res/textures/EnemiesSprites.png"));
        //Goomba movements
        goombaMovement = new BufferedImage[2];
        goombaMovement[0] = enemySheet.crop(0, 0, width16, height16);
        goombaMovement[1] = enemySheet.crop(width16, 0, width16, height16);
        goombaDeath = enemySheet.crop(width16*21, 0, width16, height16);
        goombaJumpDeath = enemySheet.crop(width16*2, 0, width16, height16);

        //Green Koopa Troopa movements
        greenKoopaTroopaLeft = new BufferedImage[2];
        greenKoopaTroopaLeft[0] = enemySheet.crop(width32*4, height32, width32, height32);
        greenKoopaTroopaLeft[1] = enemySheet.crop(width32*5, height32, width32, height32);
        greenKoopaTroopaRight = new BufferedImage[2];
        greenKoopaTroopaRight[0] = enemySheet.crop(width32*6, height32, width32, height32);
        greenKoopaTroopaRight[1] = enemySheet.crop(width32*7, height32, width32, height32);
        flyingGreenKoopaTroopaRight = new BufferedImage[2];
        flyingGreenKoopaTroopaRight[0] = enemySheet.crop(width32*2, height32, width32, height32);
        flyingGreenKoopaTroopaRight[1] = enemySheet.crop(width32*3, height32, width32, height32);
        flyingGreenKoopaTroopaLeft = new BufferedImage[2];
        flyingGreenKoopaTroopaLeft[0] = enemySheet.crop(0, height32, width32, height32);
        flyingGreenKoopaTroopaLeft[1] = enemySheet.crop(width32, height32, width32, height32);
        greenKoopaTroopaDeath = enemySheet.crop(width32*9, height32, width32, height32);
        greenKoopaTroopaShell = enemySheet.crop(width32*8, height32, width32, height32);

        //Red Koopa Troopa movements
        redKoopaTroopaLeft = new BufferedImage[2];
        redKoopaTroopaLeft[0] = enemySheet.crop(width32*4, height32*2, width32, height32);
        redKoopaTroopaLeft[1] = enemySheet.crop(width32*5, height32*2, width32, height32);
        redKoopaTroopaRight = new BufferedImage[2];
        redKoopaTroopaRight[0] = enemySheet.crop(width32*6, height32*2, width32, height32);
        redKoopaTroopaRight[1] = enemySheet.crop(width32*7, height32*2, width32, height32);
        flyingRedKoopaTroopaRight = new BufferedImage[2];
        flyingRedKoopaTroopaRight[0] = enemySheet.crop(width32*2, height32*2, width32, height32);
        flyingRedKoopaTroopaRight[1] = enemySheet.crop(width32*3, height32*2, width32, height32);
        flyingRedKoopaTroopaLeft = new BufferedImage[2];
        flyingRedKoopaTroopaLeft[0] = enemySheet.crop(0, height32*2, width32, height32);
        flyingRedKoopaTroopaLeft[1] = enemySheet.crop(width32, height32*2, width32, height32);
        redKoopaTroopaDeath = enemySheet.crop(width32*9, height32*2, width32, height32);
        redKoopaTroopaShell = enemySheet.crop(width32*8, height32*2, width32, height32);

        //Hammer brothers movements + hammer
        hammerBrotherLeft = new BufferedImage[4];
        hammerBrotherLeft[0] = enemySheet.crop(0, height32*3, width32, height32);
        hammerBrotherLeft[1] = enemySheet.crop(width32, height32*3, width32, height32);
        hammerBrotherLeft[2] = enemySheet.crop(width32*2, height32*3, width32, height32);
        hammerBrotherLeft[3] = enemySheet.crop(width32, height32*3, width32, height32);
        hammerBrotherRight = new BufferedImage[4];
        hammerBrotherRight[0] = enemySheet.crop(width32*3, height32*3, width32, height32);
        hammerBrotherRight[1] = enemySheet.crop(width32*4, height32*3, width32, height32);
        hammerBrotherRight[2] = enemySheet.crop(width32*5, height32*3, width32, height32);
        hammerBrotherRight[3] = enemySheet.crop(width32*4, height32*3, width32, height32);
        hammerThrownRight = new BufferedImage[4];
        hammerThrownRight[0] = enemySheet.crop(width16*10, 0, width16, height16);
        hammerThrownRight[1] = enemySheet.crop(width16*11, 0, width16, height16);
        hammerThrownRight[2] = enemySheet.crop(width16*12, 0, width16, height16);
        hammerThrownRight[3] = enemySheet.crop(width16*9, 0, width16, height16);
        hammerThrownLeft = new BufferedImage[4];
        hammerThrownLeft[0] = enemySheet.crop(width16*10, 0, width16, height16);
        hammerThrownLeft[1] = enemySheet.crop(width16*9, 0, width16, height16);
        hammerThrownLeft[2] = enemySheet.crop(width16*12, 0, width16, height16);
        hammerThrownLeft[3] = enemySheet.crop(width16*11, 0, width16, height16);

        //Lakitu's movements + dropping beetle
        lakitu = new BufferedImage[4];
        lakitu[0] = enemySheet.crop(width32*6, height32*3, width32, height32);
        lakitu[1] = enemySheet.crop(width32*7, height32*3, width32, height32);
        lakitu[2] = enemySheet.crop(width32*8, height32*3, width32, height32);
        lakitu[3] = enemySheet.crop(width32*7, height32*3, width32, height32);
        beetleThrownDown = new BufferedImage[2];
        beetleThrownDown[0] = enemySheet.crop(width16*17, 0, width16, height16);
        beetleThrownDown[1] = enemySheet.crop(width16*18, 0, width16, height16);

        //Beetle movements
        beetleLeft = new BufferedImage[2];
        beetleLeft[0] = enemySheet.crop(width16*13, 0, width16, height16);
        beetleLeft[1] = enemySheet.crop(width16*14, 0, width16, height16);
        beetleRight = new BufferedImage[2];
        beetleRight[0] = enemySheet.crop(width16*15, 0, width16, height16);
        beetleRight[1] = enemySheet.crop(width16*16, 0, width16, height16);

        //Piranha plant movement
        piranhaPlant = new BufferedImage[2];
        piranhaPlant[0] = enemySheet.crop(width32*9, height32*3, width32, height32);
        piranhaPlant[1] = enemySheet.crop(width32*10, height32*3, width32, height32);

        //Bullet Bill movements + canon
        bulletBillCanon = enemySheet.crop(width32*11, height32*3, width32, height32);
        bulletBillRight = enemySheet.crop(width16*19, 0, width16, height16);
        bulletBillLeft = enemySheet.crop(width16*20, 0, width16, height16);

        //Bowser's movements + breathing fire
        bowserLeft = new BufferedImage[4];
        bowserLeft[0] = enemySheet.crop(0, height32*4, width32, height32);
        bowserLeft[1] = enemySheet.crop(width32, height32*4, width32, height32);
        bowserLeft[2] = enemySheet.crop(width32*2, height32*4, width32, height32);
        bowserLeft[3] = enemySheet.crop(width32*3, height32*4, width32, height32);
        bowserRight = new BufferedImage[4];
        bowserRight[0] = enemySheet.crop(width32*4, height32*4, width32, height32);
        bowserRight[1] = enemySheet.crop(width32*5, height32*4, width32, height32);
        bowserRight[2] = enemySheet.crop(width32*6, height32*4, width32, height32);
        bowserRight[3] = enemySheet.crop(width32*7, height32*4, width32, height32);
        bowserFireRight = new BufferedImage[2];
        bowserFireRight[0] = enemySheet.crop(width32*8, height32*4, width32, height32);
        bowserFireRight[1] = enemySheet.crop(width32*9, height32*4, width32, height32);
        bowserFireLeft = new BufferedImage[2];
        bowserFireLeft[0] = enemySheet.crop(width32*10, height32*4, width32, height32);
        bowserFireLeft[1] = enemySheet.crop(width32*11, height32*4, width32, height32);

        SpriteSheet levelSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/LevelSprites.png"));
        //first line
        grid = levelSheet.crop(0, 0, width16, height16);
        threeTopLeft = levelSheet.crop(width16, 0, width16, height16);
        threeTopMiddle = levelSheet.crop(width16*2, 0, width16, height16);
        threeTopRight = levelSheet.crop(width16*3, 0, width16, height16);
        threeWood = levelSheet.crop(width16*4, 0, width16, height16);
        mushroomTopLeft = levelSheet.crop(width16*5, 0, width16, height16);
        mushroomTopMiddle = levelSheet.crop(width16*6, 0, width16, height16);
        mushroomTopRight = levelSheet.crop(width16*7, 0, width16, height16);
        mushroomStemTop = levelSheet.crop(width16*8, 0, width16, height16);
        mushroomStemElse = levelSheet.crop(width16*9, 0, width16, height16);
        castleFlag = levelSheet.crop(width16*10, 0, width16, height16);
        questionBox = new BufferedImage[4];
        questionBox[0] = levelSheet.crop(width16*11, 0, width16, height16);
        questionBox[1] = levelSheet.crop(width16*12, 0, width16, height16);
        questionBox[2] = levelSheet.crop(width16*13, 0, width16, height16);
        questionBox[3] = levelSheet.crop(width16*12, 0, width16, height16);
        axe = new BufferedImage[4];
        axe[0] = levelSheet.crop(width16*14, 0, width16, height16);
        axe[1] = levelSheet.crop(width16*15, 0, width16, height16);
        axe[2] = levelSheet.crop(width16*16, 0, width16, height16);
        axe[3] = levelSheet.crop(width16*17, 0, width16, height16);
        levelPlatform1 = levelSheet.crop(width16*18, 0, width16, height16);
        levelPlatform2 = levelSheet.crop(width16*19, 0, width16, height16);
        levelPlatform3 = levelSheet.crop(width16*20, 0, width16, height16);
        levelPlatform4 = levelSheet.crop(width16*21, 0, width16, height16);
        levelPlatform5 = levelSheet.crop(width16*22, 0, width16, height16);
        levelPlatform6 = levelSheet.crop(width16*23, 0, width16, height16);
        //Second Line
        redMushroom = levelSheet.crop(0, height16, width16, height16);
        greenMushroom = levelSheet.crop(width16, height16, width16, height16);
        mushroomPowerUp = levelSheet.crop(width16*2, height16, width16, height16);
        extraLifePowerUp = levelSheet.crop(width16*3, height16, width16, height16);
        fireFlower = new BufferedImage[4];
        fireFlower[0] = levelSheet.crop(width16*4, height16, width16, height16);
        fireFlower[1] = levelSheet.crop(width16*5, height16, width16, height16);
        fireFlower[2] = levelSheet.crop(width16*6, height16, width16, height16);
        fireFlower[3] = levelSheet.crop(width16*7, height16, width16, height16);
        star = new BufferedImage[4];
        star[0] = levelSheet.crop(width16*8, height16, width16, height16);
        star[1] = levelSheet.crop(width16*9, height16, width16, height16);
        star[2] = levelSheet.crop(width16*10, height16, width16, height16);
        star[3] = levelSheet.crop(width16*11, height16, width16, height16);
        coin = new BufferedImage[5];
        coin[0] = levelSheet.crop(width16*12, height16, width16, height16);
        coin[1] = levelSheet.crop(width16*13, height16, width16, height16);
        coin[2] = levelSheet.crop(width16*14, height16, width16, height16);
        coin[3] = levelSheet.crop(width16*13, height16, width16, height16);
        coin[4] = levelSheet.crop(width16*12, height16, width16, height16);
        boxCoin = new BufferedImage[4];
        boxCoin[0] = levelSheet.crop(width16*15, height16, width16, height16);
        boxCoin[1] = levelSheet.crop(width16*16, height16, width16, height16);
        boxCoin[2] = levelSheet.crop(width16*17, height16, width16, height16);
        boxCoin[3] = levelSheet.crop(width16*18, height16, width16, height16);
        finishFlag = levelSheet.crop(width16*19, height16, width16, height16);
        water = levelSheet.crop(width16*20, height16, width16, height16);
        lava = levelSheet.crop(width16*21, height16, width16, height16);
        //Third line
        singleCloud1 = levelSheet.crop(0, height32, width16, height16);
        singleCloud2 = levelSheet.crop(width16, height32, width16, height16);
        smallThree1 = levelSheet.crop(width16*2, height32, width16, height16);
        tubeLeft1 = levelSheet.crop(width16*4, height32, width16, height16);
        tubeLeft2 = levelSheet.crop(width16*5, height32, width16, height16);
        tubeUp1 = levelSheet.crop(width16*6, height32, width16, height16);
        tubeUp2 = levelSheet.crop(width16*7, height32, width16, height16);
        tubeMiddle1 = levelSheet.crop(width16*8, height32, width16, height16);
        tubeMiddle2 = levelSheet.crop(width16*9, height32, width16, height16);
        tubeCore1 = levelSheet.crop(width16*10, height32, width16, height16);
        tubeCore2 = levelSheet.crop(width16*11, height32, width16, height16);
        tubeDown1 = levelSheet.crop(width16*12, height32, width16, height16);
        tubeDown2 = levelSheet.crop(width16*13, height32, width16, height16);
        toad1 = levelSheet.crop(width16*14, height32, width16, height16);
        peach1 = levelSheet.crop(width16*15, height32, width16, height16);
        skyBackground = levelSheet.crop(width32*8, height32, width32, height32);
        waterBackground = levelSheet.crop(width32*9, height32, width16, height16);
        lavaBackground = levelSheet.crop(width32*10, height32, width16, height16);
        blackBackground = levelSheet.crop(width32*11, height32, width16, height16);
        castleGateOpen1 = levelSheet.crop(width16*24, height32, width16, height16);
        castleGateOpen2 = levelSheet.crop(width16*25, height32, width16, height16);
        doubleCloud1 = levelSheet.crop(width16*26, height32, width16, height16);
        doubleCloud2 = levelSheet.crop(width16*27, height32, width16, height16);
        doubleCloud3 = levelSheet.crop(width16*28, height32, width16, height16);
        smallHill1 = levelSheet.crop(width16*29, height32, width16, height16);
        smallHill2 = levelSheet.crop(width16*30, height32, width16, height16);
        smallHill3 = levelSheet.crop(width16*31, height32, width16, height16);
        //Fourth line
        singleCloud3 = levelSheet.crop(0, height16*3, width16, height16);
        singleCloud4 = levelSheet.crop(width16, height16*3, width16, height16);
        smallThree2 = levelSheet.crop(width16*2, height16*3, width16, height16);
        tubeLeft3 = levelSheet.crop(width16*4, height16*3, width16, height16);
        tubeLeft4 = levelSheet.crop(width16*5, height16*3, width16, height16);
        tubeUp3 = levelSheet.crop(width16*6, height16*3, width16, height16);
        tubeUp4 = levelSheet.crop(width16*7, height16*3, width16, height16);
        tubeMiddle3 = levelSheet.crop(width16*8, height16*3, width16, height16);
        tubeMiddle4 = levelSheet.crop(width16*9, height16*3, width16, height16);
        tubeCore3 = levelSheet.crop(width16*10, height16*3, width16, height16);
        tubeCore4 = levelSheet.crop(width16*11, height16*3, width16, height16);
        tubeDown3 = levelSheet.crop(width16*12, height16*3, width16, height16);
        tubeDown4 = levelSheet.crop(width16*13, height16*3, width16, height16);
        toad2 = levelSheet.crop(width16*14, height16*3, width16, height16);
        peach2 = levelSheet.crop(width16*15, height16*3, width16, height16);
        castleGateOpen3 = levelSheet.crop(width16*24, height16*3, width16, height16);
        castleGateOpen4 = levelSheet.crop(width16*25, height16*3, width16, height16);
        doubleCloud4 = levelSheet.crop(width16*26, height16*3, width16, height16);
        doubleCloud5 = levelSheet.crop(width16*27, height16*3, width16, height16);
        doubleCloud6 = levelSheet.crop(width16*28, height16*3, width16, height16);
        smallHill4 = levelSheet.crop(width16*29, height16*3, width16, height16);
        smallHill5 = levelSheet.crop(width16*30, height16*3, width16, height16);
        smallHill6 = levelSheet.crop(width16*31, height16*3, width16, height16);
        //Fifth Line
        tripleCloud1 = levelSheet.crop(0, height32*2, width16, height16);
        tripleCloud2 = levelSheet.crop(width16, height32*2, width16, height16);
        tripleCloud3 = levelSheet.crop(width16*2, height32*2, width16, height16);
        tripleCloud4 = levelSheet.crop(width16*3, height32*2, width16, height16);
        bigThree1 = levelSheet.crop(width16*4, height32*2, width16, height16);
        bigHill1 = levelSheet.crop(width16*5, height32*2, width16, height16);
        bigHill2 = levelSheet.crop(width16*6, height32*2, width16, height16);
        bigHill3 = levelSheet.crop(width16*7, height32*2, width16, height16);
        bigHill4 = levelSheet.crop(width16*8, height32*2, width16, height16);
        bigHill5 = levelSheet.crop(width16*9, height32*2, width16, height16);
        //Sixth Line
        tripleCloud5 = levelSheet.crop(0, height16*5, width16, height16);
        tripleCloud6 = levelSheet.crop(width16, height16*5, width16, height16);
        tripleCloud7 = levelSheet.crop(width16*2, height16*5, width16, height16);
        tripleCloud8 = levelSheet.crop(width16*3, height16*5, width16, height16);
        bigThree2 = levelSheet.crop(width16*4, height16*5, width16, height16);
        bigHill6 = levelSheet.crop(width16*5, height16*5, width16, height16);
        bigHill7 = levelSheet.crop(width16*6, height16*5, width16, height16);
        bigHill8 = levelSheet.crop(width16*7, height16*5, width16, height16);
        bigHill9 = levelSheet.crop(width16*8, height16*5, width16, height16);
        bigHill10 = levelSheet.crop(width16*9, height16*5, width16, height16);
        //Seventh Line
        bigThree3 = levelSheet.crop(width16*4, height32*3, width16, height16);
        bigHill11 = levelSheet.crop(width16*5, height32*3, width16, height16);
        bigHill12 = levelSheet.crop(width16*6, height32*3, width16, height16);
        bigHill13 = levelSheet.crop(width16*7, height32*3, width16, height16);
        bigHill14 = levelSheet.crop(width16*8, height32*3, width16, height16);
        bigHill15 = levelSheet.crop(width16*9, height32*3, width16, height16);
        //Eight Line
        smallCastle1 = levelSheet.crop(0, height16*7, width16, height16);
        smallCastle2 = levelSheet.crop(width16, height16*7, width16, height16);
        smallCastle3 = levelSheet.crop(width16*2, height16*7, width16, height16);
        smallCastle4 = levelSheet.crop(width16*3, height16*7, width16, height16);
        smallCastle5 = levelSheet.crop(width16*4, height16*7, width16, height16);
        //Ninth Line
        smallCastle6 = levelSheet.crop(0, height16*8, width16, height16);
        smallCastle7 = levelSheet.crop(width16, height16*8, width16, height16);
        smallCastle8 = levelSheet.crop(width16*2, height16*8, width16, height16);
        smallCastle9 = levelSheet.crop(width16*3, height16*8, width16, height16);
        smallCastle10 = levelSheet.crop(width16*4, height16*8, width16, height16);
        //Tenth Line
        smallCastle11 = levelSheet.crop(0, height16*9, width16, height16);
        smallCastle12 = levelSheet.crop(width16, height16*9, width16, height16);
        smallCastle13 = levelSheet.crop(width16*2, height16*9, width16, height16);
        smallCastle14 = levelSheet.crop(width16*3, height16*9, width16, height16);
        smallCastle15 = levelSheet.crop(width16*4, height16*9, width16, height16);
        //Eleventh Line
        smallCastle16 = levelSheet.crop(0, height16*10, width16, height16);
        smallCastle17 = levelSheet.crop(width16, height16*10, width16, height16);
        smallCastle18 = levelSheet.crop(width16*2, height16*10, width16, height16);
        smallCastle19 = levelSheet.crop(width16*3, height16*10, width16, height16);
        smallCastle20 = levelSheet.crop(width16*4, height16*10, width16, height16);
        //Twelfth Line
        smallCastle21 = levelSheet.crop(0, height16*11, width16, height16);
        smallCastle22 = levelSheet.crop(width16, height16*11, width16, height16);
        smallCastle23 = levelSheet.crop(width16*2, height16*11, width16, height16);
        smallCastle24 = levelSheet.crop(width16*3, height16*11, width16, height16);
        smallCastle25 = levelSheet.crop(width16*4, height16*11, width16, height16);

        SpriteSheet flagPoleSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/FinishPole.png"));
        //Flag pole movements
        emptyFlagPole = flagPoleSheet.crop(width32*7, height32*6, width16*11, height16*11);
        topFlagPole = flagPoleSheet.crop(width16*7, 0, width16*11, height16*11);
        bottomFlagPole = flagPoleSheet.crop(0, 0, width16*11, height16*11);
        flagPole = new BufferedImage[5];
        flagPole[0] = flagPoleSheet.crop(width16*7, height32*6, width16*11, height16*11);
        flagPole[1] = flagPoleSheet.crop(0, width32*6, width16*11, height16*11);
        flagPole[2] = flagPoleSheet.crop(width32*7, 0, width16*11, height16*11);
        flagPole[3] = flagPoleSheet.crop(width16*7, 0, width16*11, height16*11);
        flagPole[4] = flagPoleSheet.crop(0, 0, width16*11, height16*11);

        SpriteSheet worldSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/smb1_misc_sprites.gif"));
        ground = worldSheet.crop(373, 124, 16, 16);
        bg = worldSheet.crop(274, 341, 306 - 274, 360 - 341);

        SpriteSheet playButton = new SpriteSheet(ImageLoader.loadImage("res/textures/PlayQuit.png"));
        play = new BufferedImage[2];
        play[0] = playButton.crop(0,0,305,80);
        play[1]= playButton.crop(305,0,305,80);
        quit = new BufferedImage[2];
        quit[0] = playButton.crop(0,80,303,80);
        quit[1] = playButton.crop(305,80,305,80);
        resume = new BufferedImage[2];
        resume[0] = playButton.crop(0,160,303,80);
        resume[1] = playButton.crop(305,160,305,80);
        exittomenu = new BufferedImage[2];
        exittomenu[0] = playButton.crop(0,240,305,80);
        exittomenu[1] = playButton.crop(305,240,305,80);
        exittodesktop = new BufferedImage[2];
        exittodesktop[0] = playButton.crop(0,320,305,80);
        exittodesktop[1] = playButton.crop(305,320,305,80);
        newGame = new BufferedImage[2];
        newGame[0] = playButton.crop(0, 405, 303, 80);
        newGame[1] = playButton.crop(305, 405, 305, 80);

        SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/Logo.png"));
        menu = new BufferedImage[3];
        menu[0] = menuSheet.crop(40, 24, 176, 88);

    }
}
