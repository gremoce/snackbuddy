import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameWorld extends World
{    
    private String[] lvlOneBackgrounds = {"background_yellow_1.png", "background_yellow_2.png", "background_yellow_3.png", "background_yellow_2.png"};
    private String[] lvlTwoBackgrounds = {"background_blue_1.png", "background_blue_2.png", "background_blue_3.png", "background_blue_2.png"};
    private String[] lvlThreeBackgrounds = {"background_pink_1.png", "background_pink_2.png", "background_pink_3.png", "background_pink_2.png"};
    private int costumeIndex = 0; 
    private int animationCount = 0;

    int level;
    
    private Player player;
    private Door door = new Door(level);
    private Timer timer;
    
    public GameWorld(int level)
    {
        super(960, 720, 1);
        this.level = level;
        
        if(level == 1) {
            levelOne();
        } else if (level == 2) {
            levelTwo();
        } else if (level == 3) {
            levelThree();
        }
    }
    
    public void act() {
        animate();
        
    }
    
    private void levelOne() {
        // Add timer
        timer = new Timer();
        timer.resetTimer();
        timer.start();
        addObject(new Timer(), getWidth() / 2 - 24, 36);
        
        // Add coins
        Coin.resetCoins();
        addObject(new Coin(), 352, 655);
        addObject(new Coin(), 750, 655);
        addObject(new Coin(), 24, 362);
        addObject(new Coin(), 24, 130);
        
        // Add platforms
        addObject(new Platform("block_1.png"), 96, 624);
        addObject(new Platform("block_2.png"), 264, 648);
        addObject(new Platform("block_3.png"), 408, 696);
        addObject(new Platform("hotdog.png"), 576, 600);
        addObject(new Platform("pizza.png"), 700, 492);
        addObject(new Platform("block_4.png"), 720, 696);
        addObject(new Platform("block_5.png"), 864, 648);
        addObject(new Platform("platform_2.png"), 820, 404);
        addObject(new Platform("burger_3.png"), 648, 292);
        addObject(new Platform("platform_8.png"), 372, 404);
        addObject(new Platform("hotdog_sauce.png"), 72, 404);
        addObject(new Platform("cookie_1.png"), 308, 292);
        addObject(new Platform("cookie_1.png"), 260, 244);
        addObject(new Platform("platform_4.png"), 96, 172);
        addObject(new Platform("cheese.png"), 448, 172);
        addObject(new Platform("platform_8.png"), 768, 172);
        
        // Add door
        door = new Door(level);
        addObject(door, 912, 100);
        
        // Add player
        player = new Player(36, 504);
        addObject(player, 36, 504);
    }
    
    private void levelTwo() {
        // Add timer
        timer = new Timer();
        timer.resetTimer();
        timer.start();
        addObject(new Timer(), getWidth() / 2 - 24, 36);
        
        // Add coins
        Coin.resetCoins();
        addObject(new Coin(), 940, 356);
        addObject(new Coin(), 48, 404);
        addObject(new Coin(), 18, 128);
        addObject(new Coin(), 940, 356);
        
        // Add platforms
        addObject(new Platform("block_snow_1.png"), 72, 672);
        addObject(new Platform("block_snow_2.png"), 192, 696);
        addObject(new Platform("cookie_2.png"), 360, 648);
        addObject(new Platform("cookie_2.png"), 312, 600);
        addObject(new Platform("macaron_white.png"), 504, 600);
        
        addObject(new Platform("block_snow_3.png"), 700, 672);
        addObject(new Platform("block_snow_4.png"), 864, 624);
        addObject(new Platform("platform_snow_3.png"), 888, 400);
        addObject(new Platform("snowman.png"), 696, 448);
        addObject(new Platform("platform_snow_4.png"), 504, 400);
        addObject(new Platform("snowman.png"), 312, 448);
        addObject(new Platform("macaron_blue.png"), 180, 348);
        addObject(new Platform("hot_chocolate.png"), 48, 448);
        
        addObject(new Platform("platform_snow_4.png"), 96, 172);
        addObject(new Platform("hot_chocolate.png"), 312, 220);
        addObject(new Platform("platform_snow_3.png"), 476, 224);
        addObject(new Platform("cookie_2.png"), 628, 220);
        addObject(new Platform("cookie_2.png"), 676, 172);
        addObject(new Platform("platform_snow_4.png"), 864, 220);
        
        // Add door
        addObject(new Door(level), 912, 148);
        
        // Add player
        player = new Player(36, 600);
        addObject(player, 36, 600);
    }
    
    private void levelThree() {
        // Add timer
        timer = new Timer();
        timer.resetTimer();
        timer.start();
        addObject(new Timer(), getWidth() / 2 - 24, 36);
        
        // Add coins
        Coin.resetCoins();
        addObject(new Coin(), 18, 350);
        addObject(new Coin(), 18, 128);
        addObject(new Coin(), 912, 460);
        addObject(new Coin(), 692, 48);

        // Add platforms
        addObject(new Platform("block_cake_2.png"), 192, 624);
        addObject(new Platform("block_cake_1.png"), 96, 648);
        addObject(new Platform("lollipop_pink.png"), 348, 684);
        addObject(new Platform("block_cake_2.png"), 506, 696);
        addObject(new Platform("lollipop_pink.png"), 664, 684);
        addObject(new Platform("lollipop_orange.png"), 736, 660);
        addObject(new Platform("lollipop_yellow.png"), 808, 636);
        addObject(new Platform("block_cake_3.png"), 912, 624);
        addObject(new Platform("cream_white.png"), 912, 504);
        addObject(new Platform("macaron_pink.png"), 812, 392);
        addObject(new Platform("donut_chocolate.png", 672, 524, -2.2), 672, 440);
        addObject(new Platform("platform_cookie_3.png"), 372, 392);
        addObject(new Platform("platform_cake_3.png"), 72, 392);
        addObject(new Platform("macaron_white.png"), 224, 292);
        addObject(new Platform("platform_2.png"), 48, 172);
        addObject(new Platform("hot_chocolate.png"), 372, 172);
        addObject(new Platform("donut_white.png", 672, 496, -3.4), 672, 224);
        addObject(new Platform("platform_4.png"), 864, 172);
        
        // Add door
        door = new Door(level);
        addObject(door, 912, 100);
        
        // Add player
        player = new Player(36, 552);
        addObject(player, 36, 552);
    }
    
    private void animate() {
        animationCount++;
        
        if (animationCount % 20 == 0) {
            if(level == 1) {
                costumeIndex = (costumeIndex + 1) % lvlOneBackgrounds.length; 
                setBackground(lvlOneBackgrounds[costumeIndex]);
            } else if (level == 2) {
                costumeIndex = (costumeIndex + 1) % lvlTwoBackgrounds.length; 
                setBackground(lvlTwoBackgrounds[costumeIndex]);
            } else if (level == 3) {
                costumeIndex = (costumeIndex + 1) % lvlThreeBackgrounds.length; 
                setBackground(lvlThreeBackgrounds[costumeIndex]);
            }
            
        }
    }
    
    public void started() {
        StartWorld.playMusic();
    }
    
    public void stopped() {
        StartWorld.stopMusic();
    }
}
