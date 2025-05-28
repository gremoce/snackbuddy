import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Welcome to SnackBuddy!
 * 
 * Help Buddy reach the door to his snacks!!
 * 
 * INSTRUCTIONS
 * 1. Use arrow keys to control Buddy - left, right, up (jump)
 * 2. Collect coins
 * 3. Finish the level within 20 seconds and collect all coins for perfect score (100)
 * 
 * CREDITS
 * Creator: Grace Tao
 * ICS3U Final Project (Jan 2025)
 * 
 * Music: "SnackBuddy!" by Grace Tao (created using MuseScore)
 * Sprite pack: Pixel Platformer by Kenney
 * Sound effects: Mixkit
 * 
 * BUGS:
 * When game is resetted, there is an error where the sound starts glitching, 
 * and gives an error message.
 */

public class StartWorld extends World
{
    private String[] backgrounds = {"background_blue_1.png", "background_blue_2.png", "background_blue_3.png", "background_blue_2.png"};
    private int costumeIndex = 0; 
    private int animationCount = 0;
    
    Button startButton = new Button("start_button.png", "start_button_2.png");
    Button infoButton = new Button("info.png", "info_2.png");;
    Button next = new Button("next.png", "next_2.png");
    
    Button lvl1 = new Button("1.png", "1_2.png");
    Button lvl2 = new Button("2.png", "2_2.png");
    Button lvl3 = new Button("3.png", "3_2.png");
    
    Button closeButtonLevels = new Button("close.png", "close.png");
    Button closeButtonInfo = new Button("close.png", "close.png");
    
    Screen infoScreen;
    Screen levelsScreen;
    
    private static GreenfootSound music = new GreenfootSound("SnackBuddy.mp3");
    
    public StartWorld()
    {
        super(960, 720, 1); 
        
        addObject(new Title(), 480, 300);
        addObject(new Image("right_sign.png"), 96, 504);
        
        
        addObject(infoButton, 912, 48);
        addObject(startButton, 480, 400);
        
        addObject(new Player(36, 504), 36, 504);
        
        addObject(new Platform("block_1.png"), 96, 624);
        addObject(new Platform("block_2.png"), 264, 648);
        addObject(new Platform("block_3.png"), 408, 696);
        addObject(new Platform("platform_3.png"), 576, 600);
        addObject(new Platform("block_4.png"), 720, 696);
        addObject(new Platform("block_5.png"), 864, 648);
        
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(startButton)){
            Greenfoot.playSound("click.wav");
            levelsScreen = new Screen("levels");
            addObject(levelsScreen, getWidth() / 2, getHeight() / 2); 
            
            addObject(lvl1, getWidth() / 2 - 96, getHeight() / 2 + 12);
            addObject(lvl2, getWidth() / 2, getHeight() / 2 + 12);
            addObject(lvl3, getWidth() / 2 + 96, getHeight() / 2 + 12);
            addObject(closeButtonLevels, 320, 296);
        }
        
        if (Greenfoot.mouseClicked(infoButton)){
            Greenfoot.playSound("click.wav");
            infoScreen = new Screen("instructions");
            
            addObject(infoScreen, getWidth() / 2, getHeight() / 2);
            addObject(next, 712, 500);
            addObject(closeButtonInfo, 224, 200);
        }
        
        if (Greenfoot.mouseClicked(next)){
            Greenfoot.playSound("click.wav");
            removeObject(next);
            removeObject(closeButtonInfo);
            removeObject(infoScreen);
            
            infoScreen = new Screen("credits");
            addObject(infoScreen, getWidth() / 2, getHeight() / 2);
            addObject(closeButtonInfo, 224, 200);

        }
        
        if (Greenfoot.mouseClicked(closeButtonInfo)){
            Greenfoot.playSound("click.wav");
            removeObject(closeButtonInfo);
            removeObject(next);
            removeObject(infoScreen);
        }
        
        if (Greenfoot.mouseClicked(closeButtonLevels)){
            Greenfoot.playSound("click.wav");
            removeObject(closeButtonLevels);
            removeObject(levelsScreen);
            removeObject(lvl1);
            removeObject(lvl2);
            removeObject(lvl3);
        }
        
        if (Greenfoot.mouseClicked(lvl1)) {
            Greenfoot.playSound("click.wav");
            Greenfoot.setWorld (new GameWorld(1));
        }
        
        if (Greenfoot.mouseClicked(lvl2)) {
            Greenfoot.playSound("click.wav");
            Greenfoot.setWorld (new GameWorld(2));
        }
        
        if (Greenfoot.mouseClicked(lvl3)) {
            Greenfoot.playSound("click.wav");
            Greenfoot.setWorld (new GameWorld(3));
        }
        
        animate();
        
    }
    
    public void started()
    {
        playMusic();
    }
     
    public void stopped()
    {
        stopMusic();
    }
    
    public static void playMusic() {
        if (!music.isPlaying()) {
            music.playLoop();
        }
    }

    public static void stopMusic() {
        if (music.isPlaying()) {
            music.stop();
        }
    }

    private void animate() {
        animationCount++;
        if (animationCount % 20 == 0) {             
            costumeIndex = (costumeIndex + 1) % backgrounds.length; 
            setBackground(backgrounds[costumeIndex]);
        }
    }    
}
